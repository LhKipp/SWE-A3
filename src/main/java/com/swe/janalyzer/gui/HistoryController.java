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
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class HistoryController {


    class PaneWithInfo{
        PaneWithInfo(ScrollPane pane) {
            this.pane = pane;
        }

        ScrollPane pane;
        ClickableProjectBox lastClickedBox;
    }

    private Map<Path, PaneWithInfo> storedHistories = new HashMap<>();
    private PaneWithInfo currentPane;

    private Comparator<Node> projectBoxesComparator;

    HistoryController(){
        projectBoxesComparator = Comparator.comparing(b ->
                ((ClickableProjectBox) b)
                        .getData().getName());
        projectBoxesComparator  = projectBoxesComparator.thenComparing(b->
                ((ClickableProjectBox) b)
                        .getData().getTimeOfAnalysis());
    }

    public synchronized PaneWithInfo getPaneOrBuild(Path storageDir){
        if (storedHistories.containsKey(storageDir)) {
            return storedHistories.get(storageDir);
        } else {
            PaneWithInfo pane = new PaneWithInfo(buildPane(storageDir));
            storedHistories.put(storageDir, pane);
            return pane;
        }
    }
    public ScrollPane getView(Path storageDir) {
        currentPane = getPaneOrBuild(storageDir);
        return currentPane.pane;
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
                boxes.getChildren().add(getProjectBox(project, file));
            } catch (Exception e) {
                unloadablePaths.add(file);
            }
        }
        sortBoxes(boxes.getChildren());

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

    private void sortBoxes(ObservableList<Node> boxes) {
        List<Node> list = new ArrayList<>(boxes);
        list.sort(projectBoxesComparator);
        boxes.clear();
        boxes.addAll(list);
    }

    private Stream<ClickableProjectBox> getCheckedBoxes(){
        return getCheckedBoxes(currentPane);
    }
    private Stream<ClickableProjectBox> getCheckedBoxes(PaneWithInfo pane){
        Pane p = (Pane) pane.pane.getContent();
        return p.getChildren().stream()
                .filter(n -> n instanceof ClickableProjectBox)
                .map(n -> (ClickableProjectBox)n)
                .filter(ClickableProjectBox::isSelected);
    }

    private Stream<Project> getCheckedProjects(){
        return getCheckedBoxes()
                .map(ClickableProjectBox::getData);
    }
    public Stream<Project> getSelectedProjects(){
        if(currentPane.lastClickedBox != null){
            return Stream.of(currentPane.lastClickedBox.getData());
        }else{
            return getCheckedProjects();
        }
    }
    public boolean hasCheckedBoxes(){
        return getCheckedBoxes().count() > 0;
    }

    public void removeCheckedProjects(){
        Pane p = (Pane) currentPane.pane.getContent();
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

    public ClickableProjectBox add(Project result, Path outputFile, Path outputDir) {
        PaneWithInfo pane = getPaneOrBuild(outputDir);
        return add(result, outputFile, pane);
    }

    public ClickableProjectBox add(Project result, Path outputPath) {
        return add(result,outputPath, currentPane);

    }

    private ClickableProjectBox add(Project result, Path outputPath, PaneWithInfo onPane){
        ClickableProjectBox newProjectBox = getProjectBox(result, outputPath);
        Node content = onPane.pane.getContent();
        Pane pane = (Pane) content;
        pane.getChildren().add(newProjectBox);
        sortBoxes(pane.getChildren());
        return newProjectBox;
    }

    private ChangeListener<Boolean> onCheckBoxValueChange;
    private EventHandler<MouseEvent> onBoxClicked;

    private ClickableProjectBox getProjectBox(Project p, Path storagePath){
        ClickableProjectBox newBox = new ClickableProjectBox(
                p,
                storagePath);
        //Order is important here, because we need to remember selected Project first
        //First add own
        newBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            if(getCheckedProjects().count() != 0){
                //Projects are checked don't do anything
                return;
            }
            clearLastSelected();
            //Add a new background
            BackgroundFill bgf[] = {new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)};
            Background background = new Background(bgf);
            ((ClickableProjectBox)e.getSource()).setBackground(background);

            currentPane.lastClickedBox = (ClickableProjectBox) e.getSource();
        });
        newBox.addEventHandler(MouseEvent.MOUSE_CLICKED, onBoxClicked);

        newBox.getCheckBox().selectedProperty().addListener((v,o,n) ->{
            clearLastSelected();
            currentPane.lastClickedBox = null;
        });
        newBox.getCheckBox().selectedProperty().addListener(onCheckBoxValueChange);
        return newBox;
    }

    public void setOnBoxClicked(EventHandler<MouseEvent> onBoxClicked) {
        this.onBoxClicked = onBoxClicked;
    }

    public void setOnCheckBoxValueChange(ChangeListener<Boolean> onCheckBoxValueChange) {
        this.onCheckBoxValueChange = onCheckBoxValueChange;
    }

    private void clearLastSelected(){
        clearLastSelected(currentPane);
    }
	private void clearLastSelected(PaneWithInfo pane){
        if(pane.lastClickedBox != null){
            BackgroundFill bgf[] = {new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)};
            Background background = new Background(bgf);
            pane.lastClickedBox.setBackground(background);
        }
    }

    public void checkOnly(final ClickableProjectBox box) {
        checkOnly(box, currentPane);
    }

    public void checkOnly(final ClickableProjectBox box, final Path outputDir) {
        checkOnly(box, getPaneOrBuild(outputDir));
    }

    private void checkOnly(final ClickableProjectBox box, final PaneWithInfo pane){
        clearLastSelected(pane);
        getCheckedBoxes(pane).forEach(b -> b.setSelected(false));
        box.setSelected(true);
    }
}
