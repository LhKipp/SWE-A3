package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import com.swe.janalyzer.gui.data.NamedPath;
import com.swe.janalyzer.gui.data.ThresholdBoxes;
import com.swe.janalyzer.util.Constants;
import com.swe.janalyzer.util.FileUtil;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.swe.janalyzer.data.metriken.*;
import com.swe.janalyzer.storage.JSONConverter;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class OptionController{
	
	
	@FXML private VBox thresholdBox;
	@FXML private List<ThresholdBoxes> thresholdBoxes;

	private NamedPath defaultPath = new NamedPath(Constants.DEFAULT_OUTPUT_DIR(), "Analyseergebnisse (default)");

	@FXML
	private TextField customPathNameBox;
	@FXML
	private TextField customPathPathBox;
	@FXML
	private TextField defaultPathPathBox;
	@FXML
	private TextField defaultPathNameBox;


	private Map<String, Double> savedThresholds;
	private Map<String, Double> currentThresholds;

	private NamedPath savedCustomPath = new NamedPath();
	private NamedPath currentCustomPath = new NamedPath();

	private BooleanProperty valuesAreChanged = new SimpleBooleanProperty(false);

	private Stage stage;

	public OptionController() {
	}

	private void resetToSavedValues(){
		customPathNameBox.setText(savedCustomPath.getCustomName());
		if(!(savedCustomPath.getPath() == null)){
			customPathPathBox.setText(savedCustomPath.getPath().toString());
		}

		for (ThresholdBoxes boxes : thresholdBoxes) {
			//reset to old value
			if(savedThresholds.containsKey(boxes.name.getText())){
				boxes.valueField.setText(String.valueOf(savedThresholds.get(boxes.name.getText())));
			}else{
				//No value has been saved before
				boxes.valueField.setText("");
			}
		}
	}

	void init(final List<MetricResult> analysedMetrics,
			  final Stage initStage){

		//Default path may not be created yet
		try {
			Files.createDirectories(defaultPath.getPath());
		} catch (IOException e) {
		    //Fail silently
		}
		this.stage = initStage;
		stage.setOnCloseRequest(e ->{
			if(valuesAreChanged.get()){
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Daten nicht gespeichert");
				alert.setHeaderText("Sie haben eventuell ungespeicherte Änderungen.\n" +
						"Sind Sie sicher, dass sie das Fenster schließen wollen?");
				//alert.setContentText("");
				ButtonType closeAndSave =
						new ButtonType("Speichern und Schließen",ButtonBar.ButtonData.YES);
				alert.getButtonTypes().clear();
				alert.getButtonTypes().addAll(ButtonType.YES, closeAndSave, ButtonType.CANCEL);
				Optional<ButtonType> buttonType = alert.showAndWait();
				if(!buttonType.isPresent()){
				    e.consume();
				    return;
				}
				ButtonType clicked = buttonType.get();
				if(clicked.equals(ButtonType.YES)){
					//okay reset and close
					resetToSavedValues();
				}else if(clicked.equals(closeAndSave)){
					onSave();
				}else if(clicked.equals(ButtonType.CANCEL)){
				    //Dont close the window
					e.consume();
				}
			}
		});

		savedThresholds = loadTresholds();
		currentThresholds = new HashMap<>(savedThresholds);

		thresholdBoxes = new ArrayList<>(analysedMetrics.size());
		thresholdBox.getChildren().addAll(
				OptionViewCreator.createThresholdList(
						analysedMetrics,
						currentThresholds,
						thresholdBoxes,
						valuesAreChanged,
						thresholdBox.widthProperty()
				));

		List<NamedPath> namedPaths = loadCustomPaths();
		if(namedPaths.isEmpty()){
			savedCustomPath = new NamedPath();
		}else{
			savedCustomPath = namedPaths.get(0);
		}
		currentCustomPath.set(savedCustomPath);

		defaultPathNameBox.setText(defaultPath.getCustomName());
		defaultPathPathBox.setText(defaultPath.getPath().toString());

		customPathNameBox.setOnAction(e ->{
			currentCustomPath.setCustomName(customPathNameBox.getText());
			valuesAreChanged.setValue(true);
		});
		//Update on change
		customPathNameBox.textProperty().addListener(((observable, oldValue, newValue) -> {
			currentCustomPath.setCustomName(customPathNameBox.getText());
			valuesAreChanged.setValue(true);
		}));

		customPathPathBox.setOnAction(e->{
		    handleInputInPathPathBox();
		});
		//TODO Should be on textProperty change but might then be heavy calc
		//Measure and change if needed
//		customPathPathBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if(!newValue){
//				handleInputInPathPathBox();
//			}
//		});

		resetToSavedValues();

	}
	private void handleInputInPathPathBox(){
		if(!FileUtil.validateFolder(customPathPathBox.getText())){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Kein gültiger Pfad");
			alert.setContentText("Der ausgesuchte Pfad ist kein Ordner.\n" +
					"Bitte stellen Sie sicher, dass der Ordner existiert.");
			alert.showAndWait();
			return;
		}

		currentCustomPath.setPath(Paths.get(customPathPathBox.getText()));
		valuesAreChanged.setValue(true);
	}

	private List<NamedPath> loadCustomPaths() {
		try {
			return JSONConverter.loadNamedPaths(Constants.GET_CUSTOM_PATH_STORAGE_FILE());
		} catch (IOException e) {
			//Silently fail nobody cares
		    return new ArrayList<>();
		}
	}

	private void saveCustomPaths() {
		try {
			JSONConverter.saveNamedPaths(Arrays.asList(savedCustomPath), Constants.GET_CUSTOM_PATH_STORAGE_FILE());
		} catch (IOException e) {
		    //Do you care?
		}
	}

	private void saveThresholds(){
		try {
			JSONConverter.saveMap(savedThresholds, Constants.GET_THRESHOLD_STORAGE_FILE());
		} catch (IOException e) {
		    //Fail silently nobody really cares
		}
	}

	private Map<String, Double> loadTresholds(){
		try {
			return JSONConverter.loadMap(Constants.GET_THRESHOLD_STORAGE_FILE());
		} catch (IOException e) {
			//Fail silently nobody cares
		    return new HashMap<>();
		}
	}

	@FXML
	public void onSave(){
		try {
				if(!FileUtil.validateFolder(customPathPathBox.getText())){
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Fehler");
						alert.setHeaderText("Kein gültiger Pfad");
						alert.setContentText("Der ausgesuchte Pfad ist kein Ordner.\n" +
								"Bitte stellen Sie sicher, dass der Ordner existiert.");
						alert.showAndWait();
						return;
				}else if(this.customPathNameBox.getText().equals("")) {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Fehler");
						alert.setHeaderText("Kein gültiger Name");
						alert.setContentText("Sie haben keinen Namen für Ihren gewählten Pfad angegeben.\n" +
								"Bitte geben Sie einen Namen an.");
						alert.showAndWait();
						return;
				}
			Files.createDirectories(Constants.GET_STORAGE_DIR());
		} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("janalyzer - Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Der angegebene Pfad ist fehlerhaft.");
				alert.showAndWait();
		}



		savedCustomPath.set(currentCustomPath);
		savedThresholds.clear();
		savedThresholds.putAll(currentThresholds);

		saveThresholds();
		saveCustomPaths();

		valuesAreChanged.setValue(false);

		stage.close();
	}


	@FXML
	public void choosePath(){
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDir = directoryChooser.showDialog(new Stage());
		if(selectedDir == null){
			return;
		}

		currentCustomPath.setPath(selectedDir.toPath());
		customPathPathBox.setText(selectedDir.getAbsolutePath());
		valuesAreChanged.setValue(true);

	}

	public Map<String, Double> getThresholds() {
		return savedThresholds;
	}

	/**
	 * Every path inside the returned list is at all times checked to be a directory and existing
	 * @return
	 */
	public List<NamedPath> getPaths(){
		return Arrays.asList(defaultPath, savedCustomPath);
	}

	public void showAndWait() {
		stage.showAndWait();
	}

	public void disableDefaultPath() {

	}
}
