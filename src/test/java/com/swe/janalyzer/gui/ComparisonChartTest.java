package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.storage.JSONConverter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ComparisonChartTest extends Application {

    @Test
    public void build() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<Project> l = new ArrayList<>();
        l.add(JSONConverter.loadSummary(Paths.get("graphs.json")));
        l.add(JSONConverter.loadSummary(Paths.get("preferences.json")));
        l.add(JSONConverter.loadSummary(Paths.get("Trees.json")));

        Scene s = new Scene(ComparisonChart.build(l, 800));
        s.getStylesheets().add("gui/chart.css");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}