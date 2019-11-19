package com.swe.janalyzer;

import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.MetricCalculatorImpl;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        MetricCalculator cal = new MetricCalculatorImpl();
        try {
            cal.calculate(Paths.get("/home/leonhard/Code/oos/p2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(args.length > 0){
            System.out.println("Handle Args cli");
        }else{
            System.out.println("Gui starten");
        }
    }
}
