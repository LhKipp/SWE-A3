package com.swe.janalyzer;

import com.swe.janalyzer.cli.CLI;
import com.swe.janalyzer.gui.GuiMain;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args )
    {
        if(args.length > 0){
            CLI cli = new CLI();
            cli.handle(args);
        }else{
            GuiMain.launch(args);
        }
    }

}
