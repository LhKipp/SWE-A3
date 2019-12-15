package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class StartController {
	
	@FXML private VBox basePane_VBox;
	@FXML private Button optionButton;
	@FXML private Button deleteButton;
	@FXML private Button analyseButton;
	@FXML private ListView<CheckBox> history; //generischer Typ muss noch geändert werden!
	@FXML private ChoiceBox<String> pathSelect; //generischer Typ muss noch geändert werden!
	private ObservableList<CheckBox> historyEntries;
	
	public StartController() {}
	
	/**
	 * Methode zum Öffnen des Options-Menüs
	 * TODO Threshholds/Pfade entgegennehmen
	 * @throws IOException
	 */
	@FXML
	private void openOptions() throws IOException {
		Parent option = FXMLLoader.load(getClass().getResource("OptionView.fxml"));
		Scene scene = new Scene(option, 306, 400); // initiale Fenstergröße muss noch angepasst werden
		Stage optionStage = new Stage();
		optionStage.initOwner((Stage) basePane_VBox.getScene().getWindow());
		optionStage.setTitle("Optionen");
		optionStage.setScene(scene);
		optionStage.show();
	}
	
	/**
	 * Methode zum Löschen von ausgewählten Projekten
	 */
	@FXML
	private void deleteSelectedProjects() {
		/**
		 * TODO Pop-Up "Sind sie sicher,dass..."
		 */
		for(CheckBox entry : this.historyEntries){
			if(entry.isSelected()) this.historyEntries.remove(entry);
		}
		this.history.setItems(this.historyEntries);
	}
	
	/**
	 * Methode zum öffnen des FolderPickers (Java Projekt auswählen -> analysieren -> Eintrag in History hinzufügen)
	 */
	@FXML
	private void openFolderPicker() {
		DirectoryChooser folderPicker = new DirectoryChooser();
		File selectedDirectory = folderPicker.showDialog((Stage) basePane_VBox.getScene().getWindow());
		
		/**
		 * TODO Fehlermeldung bei leerer Pfadangabe(?)
		 */
		if(selectedDirectory == null){
		     //No Directory selected
			/**
			 * TODO alle .java dateien in allen Unterverzeichnissen einlesen/analysieren und Ergebnis abspeichern
			 */
		} else {
		     System.out.println(selectedDirectory.getAbsolutePath());
		}
	}
}
