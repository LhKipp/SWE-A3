package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.gui.util.ClickableProjectBox;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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

        List<Path> unloadablePaths = new ArrayList<>();
        for (Path file : allFiles) {
            Project project;
            try {
                project = JSONConverter.loadSummary(file);
                boxes.getChildren().addAll(getProjectBox(project, file));
            } catch (Exception e) {
                unloadablePaths.add(file);
            }
        }
        //Give user info about unloaded files
        if(!unloadablePaths.isEmpty()){
            StringBuilder builder = new StringBuilder(unloadablePaths.size() * 30);
            builder.append("Die folgenden Dateien konnten nicht geladen werden\n");
            unloadablePaths.forEach(p -> {
                builder.append(p.toString());
                builder.append("\n");
            });

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("janalyzer - Dialog");
            a.setHeaderText(null);
            a.setContentText(builder.toString());
            a.showAndWait();
        }

        return root;
    }

    public Stream<Project> getSelectedProjects(){
        Pane p = (Pane) currentPane.getContent();
        return p.getChildren().stream()
                .filter(n -> n instanceof ClickableProjectBox)
                .map(n -> (ClickableProjectBox)n)
                .filter(ClickableProjectBox::isSelected)
                .map(ClickableProjectBox::getData);
    }

    void removeSelectedProjects(){
        Pane p = (Pane) currentPane.getContent();
        p.getChildren().removeIf(n ->{
            if(!(n instanceof ClickableProjectBox)){
                return false;
            }
            final ClickableProjectBox b = (ClickableProjectBox) n;
            if(b.isSelected()){
                return b.removeStorageFile();
            }else{
                return false;
            }
        });

    }

    public void add(Project result, Path outputPath) {
        ClickableProjectBox newProjectBox = getProjectBox(result, outputPath);

        Node content = currentPane.getContent();
        Pane pane = (Pane) content;
        pane.getChildren().add(newProjectBox);
    }

    private ChangeListener<Boolean> onCheckBoxValueChange;
    private EventHandler<MouseEvent> onBoxClicked;

    private ClickableProjectBox getProjectBox(Project p, Path storagePath){
        return new ClickableProjectBox(p,
                storagePath,
                onCheckBoxValueChange,
                onBoxClicked);
    }

    public void setOnBoxClicked(EventHandler<MouseEvent> onBoxClicked) {
        this.onBoxClicked = onBoxClicked;
    }

    public void setOnCheckBoxValueChange(ChangeListener<Boolean> onCheckBoxValueChange) {
        this.onCheckBoxValueChange = onCheckBoxValueChange;
    }
    
    public void selectNewProject(Project result) {
		Node content = currentPane.getContent();
        Pane pane = (Pane) content;
        ObservableList<Node> historyBoxes = pane.getChildren();
		for(Node curNode : historyBoxes) {
			if(((ClickableProjectBox) curNode).getData() == result) {
				((ClickableProjectBox) curNode).setSelected(true);
			}
			else if(((ClickableProjectBox) curNode).isSelected()) {
				((ClickableProjectBox) curNode).setSelected(false);
			}
		}
	}

	public void clearAllBackground() {
		Node content = currentPane.getContent();
        Pane pane = (Pane) content;
        ObservableList<Node> historyBoxes = pane.getChildren();
        BackgroundFill bgf[] = {new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)};
		Background background = new Background(bgf);
		for(Node curNode : historyBoxes) {
			((ClickableProjectBox) curNode).setBackground(background);
		}
	}
}
