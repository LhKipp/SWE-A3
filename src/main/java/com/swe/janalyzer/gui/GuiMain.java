package com.swe.janalyzer.gui;

import java.io.IOException;

import javafx.application.Application;
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
		startScene.getStylesheets().addAll("gui/chart.css", "gui/detailChart.css");
		primaryStage.setTitle("janalyzer");
		primaryStage.setScene(startScene);
		primaryStage.setResizable(false);
		controller.init(primaryStage);
		primaryStage.show();
	}


}

