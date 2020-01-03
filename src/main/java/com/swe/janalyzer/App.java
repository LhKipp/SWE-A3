package com.swe.janalyzer;

import com.swe.janalyzer.cli.CLI;
import com.swe.janalyzer.gui.GuiMain;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static int main(String[] args )
    {
        if(args.length > 0){
            CLI cli = new CLI();
            return cli.handle(args);
        }else{
            launch(args);
            return 0;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new GuiMain().start(primaryStage);
    }
}
