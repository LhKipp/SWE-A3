package com.swe.janalyzer.gui;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.text.TableView;

import org.omg.CORBA.INITIALIZE;

import com.swe.janalyzer.analysis.MetricCalculator;
import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.*;
import com.swe.janalyzer.data.metriken.*;
//import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.IOExceptionWithFile;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class OptionController{
	
	
	@FXML private TextField DITField;
	@FXML private TextField WMCField;
	@FXML private TextField CCField;
	@FXML private TextField LOCField;
	@FXML private Button SpeichernButton;
	
	public OptionController() {
	}
	
	
	
	
}
