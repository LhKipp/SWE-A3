package com.swe.janalyzer;

import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.MetricCalculatorImpl;

import java.io.IOException;
import java.nio.file.Paths;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.ClassSpecifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length > 0){
            System.out.println("Handle Args cli");
        }else{
            System.out.println("Gui starten");
        }
    }
}
