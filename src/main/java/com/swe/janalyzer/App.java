package com.swe.janalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.HelpFormatter;

import com.swe.janalyzer.cli.*;
import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.Constants;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NullPointerException, IOException
    {
        if(args.length > 0){
            System.out.println("Handle Args cli");
            CLI abfrageCli = new CLI();
            abfrageCli.cli(args);

            //projectRoot = project Root
            //outputPath = speicherPfad
            Summary sum = null;
            
            try {
                sum = new MetricCalculatorImpl().calculate(Constants.projectRoot);
            } catch (IOException e) {
            	System.out.println("Could not open file "+ "$aktuelleDatei" + ". Stopping execution.");
                e.printStackTrace();
            }
            
            JSONConverter.saveSummary(sum, Constants.outputPath);

        }else{
            System.out.println("Gui starten");
        }
    }
}
