package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.gui.util.ColorProvider;
import com.swe.janalyzer.gui.util.Percentage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparisonChart {


    public static ScrollPane build(List<Project> projects,
                                   double totalWidth,
                                   Map<String, Double> thresholds){

        List<List<String>> listStream = projects.stream()
                .map(Project::getAnalysedMetrics)
                .map(l -> l.stream()
                        .filter(MetricResult::isRepresantableInBarChart)
                        .map(MetricResult::getMetricName)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<String> intersection = new ArrayList<>(listStream.get(0));
        for (int i = 1; i < listStream.size(); i++) {
            intersection.retainAll(listStream.get(i));
        }

        ScrollPane root = new ScrollPane();
        VBox rootPane = new VBox();
        root.setContent(rootPane);

        intersection.forEach(metricName ->{
            final double maxMetricValue = projects.stream()
                    .map(Project::getAnalysedMetrics)
                    .map(l -> l.stream().
                            filter(metricResult -> metricResult.getMetricName().equals(metricName))
                            .findAny().orElse(null))
                    .mapToDouble(MetricResult::getFirstResultAsDouble)
                    .max().orElse(0);

            VBox metricRoot = new VBox();
            metricRoot.spacingProperty().setValue(0);
            rootPane.getChildren().add(metricRoot);

            Label metricNameBox = new Label(metricName);
            metricNameBox.setId("chart-metric-label");
            metricNameBox.setPrefWidth(totalWidth);
            metricRoot.getChildren().add(metricNameBox);

            Pane barPane = new VBox();
            barPane.setStyle("-fx-border-color: black");
            barPane.setPrefWidth(totalWidth);
            metricRoot.getChildren().add(barPane);

            ColorProvider colors = new ColorProvider();
            //TODO this works but not if ever values are parsed to longs or if one value == Double.MAX_Value
            //For now it should be fine
            final double threshold = thresholds.getOrDefault(metricName, Double.MAX_VALUE);
            for(Project p : projects){
                HBox bar = buildBar(p.getName(),
                        p.getAnalysedMetrics().stream()
                                .filter(m -> m.getMetricName().equals(metricName))
                                .mapToDouble(MetricResult::getFirstResultAsDouble)
                                .findAny()
                                .orElse(0),
                        maxMetricValue,
                        threshold,
                        totalWidth,
                        colors.next()
                        );


                barPane.getChildren().add(bar);
            }


        });

        return root;
    }

    private static HBox buildBar(
            final String projectName,
            final double metricValue,
            final double maxValueFromProjects,
            final double limitValue,
            final double totalWidth,
            final String color){

        final double textWidth = totalWidth * 0.35;
        final double barWidth = totalWidth * 0.65;

        HBox root = new HBox();

        final String projectNameWithValue = projectName + ": " + Double.toString(metricValue);
        Label label = new Label(projectNameWithValue);
        //TODO set style for label
        label.setPrefWidth(textWidth);
        label.setMaxWidth(textWidth);
        label.setId("chart-project-and-value");
        if(metricValue >= limitValue){
            label.setStyle("-fx-text-fill: red;");
        }else{
            label.setStyle("-fx-text-fill: " + color + ";");
        }
        Tooltip fullNameWithValue = new Tooltip(projectNameWithValue);
        Tooltip.install(label, fullNameWithValue);
        root.getChildren().add(label);


        //Dont divide by 0
        //If maxVal == 0, every metric is maxed out
        final double valueRelativeInPercentage =
          maxValueFromProjects == 0 ?
                  1
                  : metricValue / maxValueFromProjects;

        final String percentageValue = Percentage.formatAsPercentage(valueRelativeInPercentage);
        Label bar = new Label();
        bar.setPrefWidth(barWidth * valueRelativeInPercentage);
        bar.setMaxWidth(barWidth * valueRelativeInPercentage);
        bar.setId("chart-bar");
        //Cant be styled through css??
        bar.setTextAlignment(TextAlignment.RIGHT);

        //TODO Is it >= or > ???
        if(metricValue >= limitValue){
            bar.setStyle("-fx-background-color: red;");
        }else{
            bar.setStyle("-fx-background-color: " + color +";");
        }

        root.getChildren().add(bar);
        //Set text on bar or beside?
        if(valueRelativeInPercentage > 0.30){
            //Text fits in bar
            bar.setText(percentageValue);
        }else{
            //Text goes on the right
            Label percentage = new Label(percentageValue);
            percentage.setId("chart-text-on-right");
            root.getChildren().add(percentage);
        }


        return root;
    }
}
