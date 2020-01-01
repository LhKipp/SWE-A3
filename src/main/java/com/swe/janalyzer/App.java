package com.swe.janalyzer;


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
    public static void main( String[] args )
    {
        if(args.length > 0){
            //0. Arg = project Root
            //1. Arg = speicherPfad
            Path projectRoot = Paths.get(args[0]);
            Summary sum = null;
//            try {
////                sum = new MetricCalculatorImpl().calculate(projectRoot);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                JSONConverter.saveSummary(sum, Paths.get(args[1]));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }else{
            System.out.println("Gui starten");
        }
    }
}
