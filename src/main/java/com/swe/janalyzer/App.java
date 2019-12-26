package com.swe.janalyzer;

import java.io.IOException;

import com.swe.janalyzer.cli.*;


import com.swe.janalyzer.analysis.MetricCalculatorImpl;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.storage.JSONConverter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( int argc, String[] args ) throws NullPointerException, IOException
    {
        if(args.length > 0){
<<<<<<< HEAD
            System.out.println("Handle Args cli");
            CLI abfrageCli = new CLI();
            abfrageCli.cli(args);
=======
            //0. Arg = project Root
            //1. Arg = speicherPfad
            Path projectRoot = Paths.get(args[0]);
            Summary sum = null;
            try {
                sum = new MetricCalculatorImpl().calculate(projectRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                JSONConverter.saveSummary(sum, Paths.get(args[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
>>>>>>> f01e1a90c6d4d6080307f74a58b4027ce5e28954
        }else{
            System.out.println("Gui starten");
        }
    }
}
