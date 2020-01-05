package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.*;
import com.swe.janalyzer.data.metriken.*;
//import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.gui.data.NamedPath;
import com.swe.janalyzer.gui.util.ClickableProjectBox;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import com.swe.janalyzer.util.IOExceptionWithFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class StartController {

	private Stage stage;
	@FXML private ScrollPane detailView;
	@FXML private ChoiceBox<NamedPath> pathSelect;

	//TODO historyBox could be scrollpane by itself and return from HistoryController simply vbox
	@FXML private VBox historyBox;

	private Analyser analyser = new Analyser();
	private OptionController optionController; //Init in initialize()
	private HistoryController historyController = new HistoryController();
	public StartController() {
	}
	
	public void init(Stage stage) {
		this.stage = stage;

	    //INIT Options BEGIN
		Pane option = null;
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

		//INIT History BEGIN
		historyController.setOnBoxClicked(e ->{
			ClickableProjectBox source = (ClickableProjectBox) e.getSource();
			long selectedProjectsCount = historyController.getSelectedProjects().count();
			if(selectedProjectsCount != 0){
				return;
			}
			//Ok detailview for project now
			detailView.setContent(buildDetailChart(source.getData()));
		});

		historyController.setOnCheckBoxValueChange((v, o, n)->{
		    handleSelectedProjects();
		});
		//INIT History End


		//INIT Path dropdown BEGIN
        pathSelect.getItems().addAll(optionController.getPaths());
		pathSelect.getSelectionModel().selectedItemProperty().addListener((v, o,n)->{
		    historyBox.getChildren().clear();
		    if(n == null){
		    	return;
			}
		    //Show new history
			historyBox.getChildren().add(historyController.getView(n.getPath()));
		    //Let detailview according to selected Projects
			handleSelectedProjects();
		});
		//TODO Save lastChosenPath and fill in here
		pathSelect.getSelectionModel().selectFirst();
		//INIT Path dropdown END
	}

	private DetailChart buildDetailChart(Project data) {
		return new DetailChart(data,
				this.detailView.getWidth(),
				optionController.getThresholds());
	}

	/**
	 * Methode zum Öffnen des Options-Menüs
	 */
	@FXML
	private void openOptions()  {
	    optionController.showAndWait();

	    //Update DetailChart if it is displayed on right, ComparisonCharts are handled by callbacks
	    DetailChart currentDetailChart = null;
	    if(detailView.getContent() instanceof DetailChart){
	    	currentDetailChart = (DetailChart) detailView.getContent();
		}
	    //TODO make NamedPaths to ObjectProperty<NamedPath> add listeners, update list if namedPath updated
		//But for now we do the cheap version
		final int selectedIndex = pathSelect.getSelectionModel().getSelectedIndex();
	    pathSelect.getItems().clear();
		pathSelect.getItems().setAll(optionController.getPaths());
		//Here are comparisoncharts and detailView from single selected box handled, but not clicked once
		pathSelect.getSelectionModel().select(selectedIndex);

		if(currentDetailChart != null){
			detailView.setContent(buildDetailChart(currentDetailChart.getCurrentProject()));
		}
	}
	
	/**
	 * Methode zum Löschen von ausgewählten Projekten
	 */
	@FXML
	private void deleteSelectedProjects() {
		long numOfChoosenFiles = historyController.getSelectedProjects().count();
		if(numOfChoosenFiles == 0){
			//User didn't select any projects
			return;
		}
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
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("janalyzer - Fehler");
				a.setHeaderText("Fehler beim Speichern");
				a.setContentText("Es trat ein Fehler beim Speichern des Ergebnisses auf. Bitte bennenen Sie die Datei eigenständig um.");
				a.showAndWait();
				outputFile = outputDir.resolve(result.getName() + "_X");

			}

			try {
				JSONConverter.saveSummary(result, outputFile);
			} catch (IOException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("janalyzer - Fehler");
				a.setHeaderText("Fehler beim Speichern");
				a.setContentText("Das analysierte Projekt konnte nicht gespeichert werden.");
				a.showAndWait();
			}
			historyController.add(result, path);
		}
	}

	private void handleSelectedProjects(){
		final List<Project> selectedProjects = historyController.getSelectedProjects().collect(Collectors.toList());
		if(selectedProjects.isEmpty()){
			//Reset pane on right
			detailView.setContent(null);
			return;
		}
		if(selectedProjects.size() == 1){
			//Set single view
			detailView.setContent(buildDetailChart(selectedProjects.get(0)));
		}else{
			//set comparison chart
			detailView.setContent(
					ComparisonChart.build(
							selectedProjects,
							detailView.getWidth(),
							optionController.getThresholds()));
		}
	}
}
