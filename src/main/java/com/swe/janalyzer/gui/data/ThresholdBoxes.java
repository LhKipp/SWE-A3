package com.swe.janalyzer.gui.data;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ThresholdBoxes {
    public Label name;
    public TextField valueField;

    public ThresholdBoxes(Label name, TextField valueField) {
        this.name = name;
        this.valueField = valueField;
    }
}
