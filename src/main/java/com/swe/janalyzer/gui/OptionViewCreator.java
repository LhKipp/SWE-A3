package com.swe.janalyzer.gui;

import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.gui.data.ThresholdBoxes;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OptionViewCreator {
    //TODO Move View definition code from OptionController to this class


    public static List<Pane> createThresholdList(
            List<MetricResult> analysedMetrics,
            Map<String, Double> thresholds,
            List<ThresholdBoxes> createdBoxes,
            BooleanProperty changeHappend,
            ReadOnlyDoubleProperty parentWidth){
        List<Pane> result = new ArrayList<>(analysedMetrics.size());
        for (MetricResult metricResult : analysedMetrics) {
            if (metricResult.isHasNumericalValues()) {
                HBox pane = new HBox();
                final String metricName = metricResult.getMetricName();
                Label metricLabel = new Label(metricResult.getMetricName());
                metricLabel.setPadding(new Insets(0,0,0,8));
                metricLabel.setId("option-threshold-label");
                metricLabel.prefWidthProperty().bind(parentWidth.divide(2));
                metricLabel.setMinWidth(250);

                TextField thresholdField = new TextField();
                thresholdField.setId("option-threshold-input");
                thresholdField.prefWidthProperty().bind(parentWidth.divide(2));
                thresholdField.setMinWidth(245);

                thresholdField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if(oldValue.equals(newValue)){
                        return;
                    }
                    if(newValue.isEmpty()){
//                        thresholdField.setText("");
                        thresholds.remove(metricResult.getMetricName());
                        changeHappend.setValue(true);
                    }else if(newValue.matches("\\d{0,12}([\\.,]\\d{0,9})?")){
                        String replace = newValue.replace(',', '.');
                        thresholdField.setText(newValue);
                        thresholds.put(metricResult.getMetricName(), Double.parseDouble(replace));
                        changeHappend.setValue(true);
                    }else{
                        thresholdField.setText(oldValue);
                    }
                });

//                //Commit on focus lose
//                thresholdField.focusedProperty().addListener((observable, oldValue, newValue) -> {
//                    if (!newValue && !thresholdField.getText().isEmpty()) {
//                        thresholds.put(metricResult.getMetricName(), Double.parseDouble(
//                                thresholdField.getText().replace(',','.')
//                        ));
//                        changeHappend.setValue(true);
//                    }
//                });

                pane.getChildren().addAll(metricLabel, thresholdField);
                createdBoxes.add(new ThresholdBoxes(metricLabel, thresholdField));
                result.add(pane);
            }
        }
        return result;
    }
}
