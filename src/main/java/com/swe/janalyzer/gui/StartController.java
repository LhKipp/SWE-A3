package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.*;
import com.swe.janalyzer.data.metriken.*;
//import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.gui.data.NamedPath;
import com.swe.janalyzer.gui.util.ClickableProjectBox;
import com.swe.janalyzer.gui.util.WaitAnimation;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import com.swe.janalyzer.util.IOExceptionWithFile;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
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

	private Set<Path> isInWaitAnimation = new HashSet<>(2);
	private WaitAnimation waitAnimation;
	public StartController() {
	}

	public void init(Stage stage) {
		this.stage = stage;
		detailView.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		//Wait animation
		waitAnimation = new WaitAnimation("Ihr Projekt wird analysiert");
		waitAnimation.setPrefWidth(detailView.getPrefWidth());

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
		Scene optionScene = new Scene(option, 500, 430); // initiale Fenstergröße muss noch angepasst werden
		optionScene.getStylesheets().addAll("gui/option.css", "gui/styles.css");
		Stage optionWindow= new Stage();

		optionWindow.initOwner(this.stage);
		optionWindow.setTitle("Optionen");
		optionWindow.setScene(optionScene);
		optionWindow.setResizable(false);
		optionController.init(analyser.getAnalysedMetrics(), optionWindow);
		//INIT OPTIONS END

		//INIT History BEGIN
		historyController.setOnBoxClicked(e ->{
		    if(!historyController.hasCheckedBoxes()){
				handleSelectedProjects();
			}
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

			//Every problem in Computer science can be solved simply by using one more if
			if(isInWaitAnimation.contains(n.getPath())){
			    detailView.setContent(waitAnimation);
			}else {
				handleSelectedProjects();
			}
		});
		//TODO Save lastChosenPath and fill in here
		pathSelect.getSelectionModel().selectFirst();
		//INIT Path dropdown END
	}

	private DetailChart buildDetailChart(Project data) {
		return new DetailChart(data,
				this.detailView.getWidth() - 5,
				optionController.getThresholds());
	}

	/**
	 * Methode zum Öffnen des Options-Menüs
	 */
	@FXML
	private void openOptions()  {
	    optionController.showAndWait();

	    //Copy the paths from option remembering the selected path
		final int selectedIndex = pathSelect.getSelectionModel().getSelectedIndex();
		pathSelect.getItems().clear();
		final List<NamedPath> paths = optionController.getPaths();
		pathSelect.getItems().setAll(paths);

        //Correct views are set in callback
		//if custom path was selected but is deleted
		if(selectedIndex >= paths.size()){
			pathSelect.getSelectionModel().selectFirst();
		}else {
			pathSelect.getSelectionModel().select(selectedIndex);
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
				historyController.removeCheckedProjects();
				detailView.setContent(null);
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
			Task<Project> sleeper = new Task<Project>() {
            @Override
            protected Project call() throws Exception {
				try {
					return analyser.analyse(path);
				} catch (ParseProblemException | IOExceptionWithFile e) {
					return null;
				}
			}};

			waitAnimation.reset();
			detailView.setContent(waitAnimation);


			Thread animater = new Thread(()->{
				while(true){
					try {
						synchronized (sleeper){
							sleeper.wait(500);
						}
					} catch (InterruptedException e) {
					    return;
					}
					Platform.runLater(waitAnimation::nextState);
				}
			});
			animater.start();


			final Path selectedPathOnStart = pathSelect.getValue().getPath();
			isInWaitAnimation.add(selectedPathOnStart);

			sleeper.setOnSucceeded(e ->{
				Project result = sleeper.getValue();
				if(result == null){
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehlerhaftes Projekt");
					a.setContentText("Das ausgewählte Projekt konnte nicht analysiert werden.");
					a.showAndWait();


					if(selectedPathOnStart.equals(pathSelect.getValue().getPath())){
						detailView.setContent(null);
					}
					//Stop waiting animation
					animater.interrupt();
					isInWaitAnimation.remove(selectedPathOnStart);

					return;
				}

				final Path outputDir = pathSelect.getValue().getPath();
				Path outputFile = null;
				//path is: pathSelect.value() / project_name + _ + Count
				try {
					outputFile = outputDir.resolve(
							result.getName() + "_" + FileUtil.analyzationNumber(path,outputDir));
				} catch (IOException ex) {
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehler beim Speichern");
					a.setContentText("Es trat ein Fehler beim Speichern des Ergebnisses auf. Bitte bennenen Sie die Datei eigenständig um.");
					a.showAndWait();
					outputFile = outputDir.resolve(result.getName() + "_X");

				}

				try {
					JSONConverter.saveSummary(result, outputFile);
				} catch (IOException exc) {
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("janalyzer - Fehler");
					a.setHeaderText("Fehler beim Speichern");
					a.setContentText("Das analysierte Projekt konnte nicht gespeichert werden.");
					a.showAndWait();
				}

				ClickableProjectBox add = historyController.add(result, outputFile, selectedPathOnStart);
				historyController.checkOnly(add, selectedPathOnStart);
				//nach dem analysieren werden die Ergebnisse rechts angezeigt

				//If the user didn't switch while loading

				if(selectedPathOnStart.equals(pathSelect.getValue().getPath())){
					detailView.setContent(buildDetailChart(result));
                }

				//Stop waiting animation
				animater.interrupt();
				isInWaitAnimation.remove(selectedPathOnStart);
			});
			new Thread(sleeper).start();

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
							detailView.getWidth() -5,
							optionController.getThresholds()));
		}
	}
}
