package com.swe.janalyzer;

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
    private static PrintStream sout;
    private static PrintStream serr;
    public static void main(String[] args )
    {
//         Create a stream to hold the output
        PrintStream pout = new PrintStream(new ByteArrayOutputStream());
        PrintStream perr = new PrintStream(new ByteArrayOutputStream());
        // IMPORTANT: Save the old System.out!
        sout = System.out;
        serr = System.err;
        // Tell Java to use your special stream
        System.setOut(pout);
        System.setErr(perr);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.setErr(serr);
        System.setOut(sout);
        List<String> raw = getParameters().getRaw();
        if(raw.isEmpty()){
            new GuiMain().start(primaryStage);
        }else{
            new CLI().handle(raw.toArray(new String[0]));
            System.exit(0);
        }
    }
}
