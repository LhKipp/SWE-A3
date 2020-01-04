package com.swe.janalyzer.gui.util;

import com.swe.janalyzer.data.metriken.Project;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClickableProjectBox extends VBox {

    private static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm 'Uhr' dd.MM.yy");

    private Project data;
    private Path storagePath;
    private CheckBox checkBox;

    private String formatDate(Date date){
        return formatter.format(date);
    }

    public ClickableProjectBox(Project project,
                               Path storagePath,
                               ChangeListener<Boolean> onCheckBoxValueChanged,
                               EventHandler<MouseEvent> onBoxClicked) {
        data = project;
        this.storagePath = storagePath;

        checkBox = new CheckBox(project.getName());
        checkBox.selectedProperty().addListener(onCheckBoxValueChanged);

        Label timeOfAnalysis = new Label(formatter.format(project.getTimeOfAnalysis()));

        this.getChildren().addAll(checkBox, timeOfAnalysis);

        this.setOnMouseClicked(onBoxClicked);
    }

    public Project getData() {
        return data;
    }

    public boolean isSelected(){
        return checkBox.isSelected();
    }

    public void removeStorageFile() {
        try {
            Files.delete(storagePath);
        } catch (IOException e) {
            //TODO Handle this error
        }
    }
}
