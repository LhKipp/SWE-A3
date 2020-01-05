package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Project;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DetailChart extends VBox {

    public Project getCurrentProject() {
        return currentProject;
    }

    private Project currentProject;

    DetailChart(final Project p, final double width, Map<String,Double> thresholds){
        this.currentProject = p;
        this.setPrefWidth(width);

        final List<MetricResult> analysedMetrics = p.getAnalysedMetrics();
        for (MetricResult metric : analysedMetrics) {
            final Label metricName = new Label(metric.getMetricName());
            metricName.setId("detailChart-metric-name-header");
            metricName.setPrefWidth(width);

            DoubleProperty threshold = null;
            if(thresholds.containsKey(metric.getMetricName())){
                threshold = new SimpleDoubleProperty(thresholds.get(metric.getMetricName()));
            }
            final VBox table =
                    tableFor(metric.getResults(),
                            width * 0.75,
                            width * 0.25,
                            threshold);

            this.getChildren().addAll(metricName, table);
        }
    }


    private VBox tableFor(final Map<String,String> map,
                          double keyWidth,
                          double valueWidth,
                          DoubleProperty threshold){
        VBox root = new VBox();
        root.setPrefWidth(keyWidth + valueWidth);

        ArrayList<Map.Entry<String, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparing(Map.Entry::getKey));

        for (Map.Entry<String, String> e : entries) {
            HBox container = new HBox();
            container.setPrefWidth(valueWidth + keyWidth);

            boolean exceedsThreshold = false;
            try{
                exceedsThreshold = threshold != null && Double.parseDouble(e.getValue()) >= threshold.get();
            }catch (NumberFormatException | NullPointerException ignored){

            }
            final Label key = new Label(e.getKey());
            key.setPrefWidth(keyWidth);
            key.setId("detailChart-table-key");
            final Label value = new Label(e.getValue());
            value.setPrefWidth(valueWidth);
            value.setId("detailChart-table-value");

            if(exceedsThreshold){
                key.setStyle("-fx-text-fill: red;");
                value.setStyle("-fx-text-fill: red;");
            }

            container.getChildren().addAll(key, value);
            root.getChildren().add(container);
        }

        return root;
    }
}
