package com.swe.janalyzer.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiMain {

	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/StartView.fxml"));
		Scene scene = new Scene(root, 900, 650);
		primaryStage.setTitle("janalyzer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
