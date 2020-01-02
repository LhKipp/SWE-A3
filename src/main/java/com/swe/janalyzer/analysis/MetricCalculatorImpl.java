package com.swe.janalyzer.analysis;

import com.github.javaparser.ParseException;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import com.swe.janalyzer.App;
import com.swe.janalyzer.analysis.cc.CCCalculator;
import com.swe.janalyzer.analysis.dit.DITCalculator;
import com.swe.janalyzer.analysis.loc.LOCCalculator;
import com.swe.janalyzer.analysis.util.FileUtil;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.cli.OptionenVerarbeitung;
import com.swe.janalyzer.util.Constants;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MetricCalculatorImpl implements MetricCalculator{

    @Override
    public Summary calculate(Path projectRoot) throws IOException, ParseProblemException {
        Summary summary = new Summary();
        //Find all java files
        List<Path> javaFiles = FileUtil.listAllJavaFiles(projectRoot);
        if(javaFiles.size() == 0) {
        	App.listZero = true;
        	throw new IOException();
        }

        int javaFileCount = (int)javaFiles.size();
        int estimatedClassCount = estimatedClassCount(javaFileCount);

        if(optimalThreadCount(javaFileCount) == 1){
            summary.setFileMetrics(new ArrayList<>(javaFileCount));
            summary.setClassMetrics(new HashMap<>(estimatedClassCount));
        }else{ //Multithreading
            //NOTE traversing over the synchronized list requires manual synchronization.
            summary.setFileMetrics(Collections.synchronizedList(new ArrayList<FileMetrics>(javaFileCount)));
            summary.setClassMetrics(new HashMap<>(estimatedClassCount));
        }
        DITCalculator ditCalc = new DITCalculator(estimatedClassCount);
        CCCalculator ccCalc= new CCCalculator(summary.getClassMetrics());
        LOCCalculator locCalc = new LOCCalculator();

        for (Path p : javaFiles){
        	//FÜR CLI
        	//Wenn verbose ist true, dann gib schritte aus
        	if(OptionenVerarbeitung.verboseIsSet == true) {
        		System.out.println("Processing file " + p);
        	}
        	
            final int sloc = locCalc.countLOCfile(p);
            summary.getFileMetrics().add(new FileMetrics(p, sloc));

            CompilationUnit cu = StaticJavaParser.parse(p);
            VoidVisitor<Void> ditVisitor = ditCalc.getASTVisitor();
            ditVisitor.visit(cu, null);

            VoidVisitor<Void> ccVisitor = ccCalc.getASTVisitor();
            ccVisitor.visit(cu, null);
            
            OptionenVerarbeitung.allFilesAnalyzed = true;
        }
             
        ditCalc.injectResultsIn(summary.getClassMetrics());

        //FÜR CLI
        if(OptionenVerarbeitung.verboseIsSet && OptionenVerarbeitung.allFilesAnalyzed) {
        	System.out.println("All files analyzed");
        	System.out.println("Writing results to DEFAULT PATH");
        	//System.out.println("Writing results to " + Constants.DEFAULT_PATH);
        	//weis nicht genau welcher path genommen wird wenn keiner gesetzt ist durch 
        	//benutzer
        }else {
        	throw new IOException();
        }
        
        return summary;
    }

    /* TODO Give a configuration option */
    private int optimalThreadCount(int fileCount){
    /*
        if  (Config.hasOption(Option.THREAD_COUNT)){
            return Config.valueOf(Option.THREAD_COUNT);
        }else{
    */
        //TODO Remove the magic numbers and get actual measurements
        return   fileCount / 10 == 0 ? 1 : fileCount / 10;
    }


    //TODO Make statistics class and/or give config option
    private int estimatedClassCount(int fileCount){
        return (int) (fileCount * 1.25);
    }

}
