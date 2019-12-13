package com.swe.janalyzer.gui;

import javafx.fxml.FXML;

public class StartController {
	
	@FXML private javafx.scene.control.Button optionButton;
	@FXML private javafx.scene.control.Button deleteButton;
	@FXML private javafx.scene.control.Button analyseButton;
	@FXML private javafx.scene.control.ChoiceBox<String> pathSelect; //generischer Typ muss noch geändert werden!
	@FXML private javafx.scene.control.ListView<String> history; //generischer Typ muss noch geändert werden!
	public StartController() {}
	
	@FXML
	private void openOptions() {
		
	}
	
	@FXML
	private void deleteSelectedProjects() {
		
	}
	
	@FXML
	private void openFolderPicker() {
		
	}
}
