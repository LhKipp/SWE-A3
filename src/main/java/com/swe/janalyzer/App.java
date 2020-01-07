package com.swe.janalyzer;

import com.swe.janalyzer.cli.CLI;
import com.swe.janalyzer.gui.GuiMain;
import javafx.application.Application;
import javafx.stage.Stage;

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
        List<String> raw = getParameters().getRaw();
        if(raw.isEmpty()){
            new GuiMain().start(primaryStage);
        }else{
            new CLI().handle(raw.toArray(new String[0]));
            System.exit(0);
        }
    }
}
