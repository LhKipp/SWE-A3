package com.swe.janalyzer.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiMain {

	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/StartView.fxml"));
		Parent root = null;
		StartController controller;
		try {
			root = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
		    //This should never happen
			e.printStackTrace();
			return;
		}
		Scene startScene = new Scene(root, 900, 650);
		startScene.getStylesheets().add("gui/chart.css");
		primaryStage.setTitle("janalyzer");
		primaryStage.setScene(startScene);
		controller.init(primaryStage);
		primaryStage.show();
	}


}
