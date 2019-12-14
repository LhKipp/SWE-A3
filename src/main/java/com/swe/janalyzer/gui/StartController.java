package com.swe.janalyzer.gui;

import javafx.fxml.FXML;

public class StartController {
	
	@FXML private javafx.scene.control.Button optionButton;
	@FXML private javafx.scene.control.Button deleteButton;
	@FXML private javafx.scene.control.Button analyseButton;
	@FXML private javafx.scene.control.ChoiceBox<String> pathSelect; //generischer Typ muss noch geändert werden!
	@FXML private javafx.scene.control.ListView<String> history; //generischer Typ muss noch geändert werden!
	public StartController() {}
	
	// Methode zum öffnen des Options-Menü
	@FXML
	private void openOptions() {
		Parent option = FXMLLoader.load(getClass().getResource("OptionView.fxml"));
		Scene scene = new Scene(option, 300, 450); // initiale Fenstergröße muss noch angepasst werden
		primaryStage.setTitle("Optionen");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// Methode zum Löschen von ausgewählten Projekten
	@FXML
	private void deleteSelectedProjects() {
		
	}
	
	// Methode zum öffnen des FolderPickers (Java Projekt auswählen -> analysieren -> Eintrag in History hinzufügen)
	@FXML
	private void openFolderPicker() {
		
	}
}
