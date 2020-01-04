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
		Scene scene = new Scene(option, 306, 400); // initiale Fenstergröße muss noch angepasst werden
		Stage optionWindow= new Stage();

		optionWindow.initOwner(stage);
		optionWindow.setTitle("Optionen");
		optionWindow.setScene(scene);

		//TODO Show and close otherwise I get an NPE. Could probably be optimized
		optionWindow.show();
		optionWindow.close();
		optionController.init(analyser.getAnalysedMetrics(), optionWindow);
		//INIT OPTIONS END

		//INIT Path dropdown BEGIN
		pathSelect.getItems().addAll(optionController.getPaths());
		//TODO Save lastChosenPath and fill in here
		pathSelect.getSelectionModel().selectFirst();
		pathSelect.getSelectionModel().selectedItemProperty().addListener((v, o,n)->{
		    historyBox.getChildren().clear();
			historyBox.getChildren().add(historyController.getView(n.getPath()));
		});
		//INIT Path dropdown END

		//INIT History BEGIN
        historyBox.getChildren().add(historyController.getView(pathSelect.getValue().getPath()));

	}
	
	/**
	 * Methode zum Öffnen des Options-Menüs
	 * @throws IOException
	 */
	@FXML
	private void openOptions()  {
	    optionController.showAndWait();
	}
	
	/**
	 * Methode zum Löschen von ausgewählten Projekten
	 */
	@FXML
	private void deleteSelectedProjects() {
		/**
		 * TODO Pop-Up "Sind sie sicher,dass..."
		 */
		historyController.removeSelectedProjects();
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
			} catch (ParseProblemException e) {
				//TODO Create Alerts like in page 60 ?
			    Alert a = new Alert(Alert.AlertType.ERROR);
			    a.showAndWait();
				return;
			} catch (IOExceptionWithFile e) {
				Alert a = new Alert(Alert.AlertType.ERROR);
				//TODO Finish this alert - was it even the correct one?
				a.setHeaderText("Fehlerhaftes Projekt");
				a.setContentText("Das ausgewählte Projekt kann nicht geladen");
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
			    //TODO Create an alert here
				System.out.println("Failed to get information how often the Project has been analysed.\n"
						+ "Please rename the result manualy");
				outputFile = outputDir.resolve(result.getName() + "_X");
			}

			try {
				JSONConverter.saveSummary(result, outputFile);
			} catch (IOException e) {
			    //TODO Create alert
				e.printStackTrace();
			}
			historyController.add(result, path);
		}
	}
}
