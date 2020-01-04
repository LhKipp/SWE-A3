package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.*;
import com.swe.janalyzer.data.metriken.*;
//import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.gui.data.NamedPath;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import com.swe.janalyzer.util.IOExceptionWithFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class StartController {

	private Stage stage;
	@FXML private VBox basePane_VBox;
	@FXML private ChoiceBox<NamedPath> pathSelect; //generischer Typ muss noch geändert werden!

	@FXML private VBox historyBox;

	private Analyser analyser = new Analyser();
	private OptionController optionController; //Init in initialize()
	private HistoryController historyController = new HistoryController();
	public StartController() {
	}
	
	public void init(Stage stage) {
		this.stage = stage;

	    //INIT Options BEGIN
		Parent option = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/OptionView.fxml"));
		try {
			option = loader.load();
		} catch (IOException e) {
		    //This should never happen
			e.printStackTrace();
		}
	 	optionController = (OptionController) loader.getController();

		//TODO Move this code to optionController init ???
		Scene optionScene = new Scene(option, 400, 400); // initiale Fenstergröße muss noch angepasst werden
		optionScene.getStylesheets().add("gui/option.css");
		Stage optionWindow= new Stage();

		optionWindow.initOwner(this.stage);
		optionWindow.setTitle("Optionen");
		optionWindow.setScene(optionScene);
		optionController.init(analyser.getAnalysedMetrics(), optionWindow);
		//INIT OPTIONS END

		//INIT Path dropdown BEGIN
        pathSelect.getItems().addAll(optionController.getPaths());
		pathSelect.getSelectionModel().selectedItemProperty().addListener((v, o,n)->{
		    historyBox.getChildren().clear();
		    if(n == null){
		    	return;
			}
			historyBox.getChildren().add(historyController.getView(n.getPath()));
		});
		//TODO Save lastChosenPath and fill in here
		pathSelect.getSelectionModel().selectFirst();

		//INIT Path dropdown END

		//INIT History BEGIN
        //INIT History End

	}
	
	/**
	 * Methode zum Öffnen des Options-Menüs
	 */
	@FXML
	private void openOptions()  {
	    optionController.showAndWait();

	    //TODO make NamedPaths to ObjectProperty<NamedPath> add listeners, update list if namedPath updated
		//But for now we do the cheap version
		final int selectedIndex = pathSelect.getSelectionModel().getSelectedIndex();
	    pathSelect.getItems().clear();
		pathSelect.getItems().setAll(optionController.getPaths());
		pathSelect.getSelectionModel().select(selectedIndex);
	}
	
	/**
	 * Methode zum Löschen von ausgewählten Projekten
	 */
	@FXML
	private void deleteSelectedProjects() {
		/**
		 * TODO Pop-Up "Sind sie sicher,dass..."
		 */

		//TODO genaue Anzahl muss noch ermittelt werden.
		int numOfChoosenFiles = 0;
		String msg;
		if(numOfChoosenFiles == 1) {
				msg = "Das Analyseergebnis wird unwiderruflich gelöscht werden. Sind Sie sicher, dass Sie fortfahren möchten?";
		}else{
				msg = "Es werden " + numOfChoosenFiles + " Analyseergebnisse unwiderruflich gelöscht. Sind Sie sicher, dass Sie fortfahren möchten?";
		}

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("janalyzer - Dialog");
			ButtonType okButton = new ButtonType("Ja", ButtonBar.ButtonData.YES);
			ButtonType abortButton = new ButtonType("Abbrechen", ButtonBar.ButtonData.CANCEL_CLOSE);
			alert.getButtonTypes().setAll(okButton,abortButton);
			alert.setHeaderText(null);
			alert.setContentText(msg);
			alert.showAndWait().ifPresent(type -> {
					if(type == okButton) {
							historyController.removeSelectedProjects();
					}
			});
	}
	
	@FXML
	private void analyseProject() {
		DirectoryChooser folderPicker = new DirectoryChooser();
		File selectedDirectory = folderPicker.showDialog(new Stage());

		/**
		 * Fehlermeldung bei leerer Pfadangabe(?)
         * Von Leo: null bedeutet, dass der Benutzer den Picker per rotes Kreuz geschlossen hat
		 */
		if(selectedDirectory == null){
		    //No Directory selected
            //return
		} else {
			Path path = selectedDirectory.toPath();
			Project result;
			try {
				result = analyser.analyse(path);
			} catch (ParseProblemException | IOExceptionWithFile e) {
				//TODO Create Alerts. This scenario was not described in the specification
			    Alert a = new Alert(AlertType.ERROR);
			    a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehlerhaftes Projekt");
					a.setContentText("Das ausgewählte Projekt konnte nicht analysiert werden.");
			    a.showAndWait();
				return;
			}

				final Path outputDir = pathSelect.getValue().getPath();
			Path outputFile = null;
			//path is: pathSelect.value() / project_name + _ + Count
			try {
				outputFile = outputDir.resolve(
						result.getName() + "_" + FileUtil.analyzationNumber(path,outputDir));
			} catch (IOException e) {
			    //TODO Create an alert here. There is no description for it in the specification.
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehler beim Speichern");
					a.setContentText("Es trat ein Fehler beim Speichern des Ergebnisses auf. Bitte bennenen Sie die Datei eigenständig um.");
				System.out.println("Failed to get information how often the Project has been analysed.\n"
						+ "Please rename the result manualy");
				outputFile = outputDir.resolve(result.getName() + "_X");
			}

			try {
				JSONConverter.saveSummary(result, outputFile);
			} catch (IOException e) {
			    //TODO Create alert. There is no description for it in the specification.
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehler beim Speichern");
					a.setContentText("Das analysierte Projekt konnte nicht gespeichert werden.");
				e.printStackTrace();
			}
			historyController.add(result, path);
		}
	}
}
