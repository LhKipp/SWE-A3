package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.gui.util.ClickableProjectBox;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HistoryController {

    private Map<Path, ScrollPane> storedHistories = new HashMap<>();
    private ScrollPane currentPane;

    public ScrollPane getView(Path storageDir) {
        if (storedHistories.containsKey(storageDir)) {
            currentPane = storedHistories.get(storageDir);
        } else {
            ScrollPane pane = buildPane(storageDir);
            storedHistories.put(storageDir, pane);
            currentPane = pane;
        }
        return currentPane;
    }

    private ScrollPane buildPane(Path storageDir) {
        ScrollPane root = new ScrollPane();
        Pane boxes = new VBox();
        root.setContent(boxes);

        List<Path> allFiles;
        try {
            allFiles = FileUtil.listAllFilesInFolder(storageDir);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Could not load files under Path: \n" +
                            storageDir.toString()
                            +"\nPlease try again later.");
            alert.showAndWait();
            return new ScrollPane();
        }

        //TODO Give user info about unloadable paths
        List<Path> unloadablePaths = new ArrayList<>();
        for (Path file : allFiles) {
            Project project;
            try {
                project = JSONConverter.loadSummary(file);
                boxes.getChildren().addAll(new ClickableProjectBox(project, file));
            } catch (Exception e) {
                unloadablePaths.add(file);
            }
        }
        if(!unloadablePaths.isEmpty()){
            StringBuilder builder = new StringBuilder(unloadablePaths.size() * 30);
            builder.append("Die folgenden Dateien konnten nicht geladen werden\n");
            unloadablePaths.forEach(p -> {
                builder.append(p.toString());
                builder.append("\n");
            });

            Alert a = new Alert(Alert.AlertType.INFORMATION ,builder.toString());
            a.showAndWait();
        }

        return root;
    }

    public Stream<Project> getSelectedProjects(){
        Pane p = (Pane) currentPane.getContent();
        return p.getChildren().stream()
                .filter(n -> n instanceof ClickableProjectBox)
                .map(n -> (ClickableProjectBox)n)
                .map(ClickableProjectBox::getData);
    }

    public void removeSelectedProjects(){
        Pane p = (Pane) currentPane.getContent();
        p.getChildren().removeIf(n ->{
            if(!(n instanceof ClickableProjectBox)){
                return false;
            }
            final ClickableProjectBox b = (ClickableProjectBox) n;
            if(b.isSelected()){
                b.removeStorageFile();
                return true;
            }else{
                return false;
            }
        });

    }

    public void add(Project result, Path path) {
        ClickableProjectBox newProjectBox = new ClickableProjectBox(result, path);

        Node content = currentPane.getContent();
        Pane pane = (Pane) content;
        pane.getChildren().add(newProjectBox);
    }
}
