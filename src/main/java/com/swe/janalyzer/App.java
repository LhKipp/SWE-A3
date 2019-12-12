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

        FunctionCC m1 = new FunctionCC("m1", 12);
        FunctionCC m2 = new FunctionCC("m2", 12);
        ArrayList<FunctionCC> functions = new ArrayList<>();
        functions.add(m1);
        functions.add(m2);
        ClassMetrics cm = new ClassMetrics();
        cm.setDit(12);
        cm.setFunctionCCs(functions);
        Map<ClassSpecifier,ClassMetrics> map = new HashMap<>(1);
        FileMetrics fm = new FileMetrics(null);
        fm.setSLOC(20);
        ArrayList<FileMetrics> fMap = new  ArrayList<>(1);
        fMap.add(fm);
        map.put(new ClassSpecifier("c1"), cm);
        Summary sum = new Summary();
        sum.setClassMetrics(map);
        sum.setFileMetrics(fMap);
        try {
            JSONConverter.save(sum, Paths.get("./result.json"));
            JSONConverter.load(Paths.get("./result.json"));
        }catch (IOException io) {

        }
    }
}
