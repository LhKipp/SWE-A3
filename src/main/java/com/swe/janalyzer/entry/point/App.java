package com.swe.janalyzer.entry.point;

import com.swe.janalyzer.cli.CLI;
import com.swe.janalyzer.gui.GuiMain;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main(String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new GuiMain().start(primaryStage);
    }
}
