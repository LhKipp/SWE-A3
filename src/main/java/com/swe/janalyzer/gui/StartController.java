package com.swe.janalyzer.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.*;
import com.swe.janalyzer.data.metriken.*;
//import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.util.IOExceptionWithFile;
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
	@FXML private ListView<CheckBox> history; //KAAN Ansichtversion der einzelnen Hisotrieeinträge, geladen von ObservableList
	@FXML private ChoiceBox<String> pathSelect; //generischer Typ muss noch geändert werden!
	@FXML private ListView<String> loc;
	private ObservableList<CheckBox> historyEntries; //KAAN Datenversion der einzelnen Historieeinträge

	private Stage optionWindow;
	private Analyser analyser = new Analyser();
	
	public StartController() {
	}
	
	@FXML
	public void initialize() {
	/*	try {
			sum = JSONConverter.load(Paths.get("./result.json"));
			history.getItems().add(new CheckBox("result.json"));
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	/**
	 * Methode zum Öffnen des Options-Menüs
	 * TODO Threshholds/Pfade entgegennehmen
	 * @throws IOException
	 */
	@FXML
	private void openOptions()  {
		if(optionWindow == null){
			Parent option = null;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/OptionView.fxml"));
			try {
				option = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			OptionController controller = (OptionController) loader.getController();

			Scene scene = new Scene(option, 306, 400); // initiale Fenstergröße muss noch angepasst werden
			optionWindow= new Stage();
			optionWindow.initOwner((Stage) basePane_VBox.getScene().getWindow());
			optionWindow.setTitle("Optionen");
			optionWindow.setScene(scene);

			//Show and close otherwise i get an NPE
			optionWindow.show();
			optionWindow.close();
			controller.init(analyser.getAnalysedMetrics());
		}
		optionWindow.showAndWait();
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
		this.history.setItems(this.historyEntries); //KAAN history wird geupdated mit den neuen historyEntries, history = eine Listview
	}
	
	/**
	 * Methode zum öffnen des FolderPickers (Java Projekt auswählen -> analysieren -> Eintrag in History hinzufügen)
	 * @throws IOException 
	 */
	@FXML
	private void openFolderPicker() throws IOException {
		DirectoryChooser folderPicker = new DirectoryChooser();
		File selectedDirectory = folderPicker.showDialog((Stage) basePane_VBox.getScene().getWindow());
		
		
		/**
		 * TODO Fehlermeldung bei leerer Pfadangabe(?)
		 */
		if(selectedDirectory == null){
		     //No Directory selected
			
		}
		
		/**
		 * TODO alle .java dateien in allen Unterverzeichnissen einlesen/analysieren und Ergebnis abspeichern
		 */
		else {
			Analyser analyser = new Analyser();
			System.out.println(selectedDirectory.getAbsolutePath()); //DEBUG
			Path path = Paths.get(selectedDirectory.getAbsolutePath());
			try {
				Project ergebnis =  analyser.analyse(path);
			} catch (ParseProblemException | IOExceptionWithFile e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			history.getItems().add(new CheckBox(path.getFileName().toString()));
			
		}
	}
}
