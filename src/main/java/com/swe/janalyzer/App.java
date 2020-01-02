package com.swe.janalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
	public static boolean notValidFolder = false;
	public static boolean listZero = false;
	
    public static void main(String[] args) throws NullPointerException, IOException
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
               
            	try {
           			JSONConverter.saveSummary(sum, Constants.outputPath);
    			}catch(IOException IOe){
    				System.out.println("Could not write results to file with path: " + "$ergebnis_datei" + ". Stopping execution.");
   				}catch(NullPointerException NPEe) {
   					System.out.println("Could not write results to file with path: " + "$ergebnis_datei" + ". Stopping execution.");
   				}
                
            } catch (IOException e) {
            	if(listZero) {
            		int lastArg = 0;
            		for(int i = 0; i < args.length; i++) {
            			lastArg = i;
            		}
            		System.out.println("Could not open file "+ args[lastArg] + ". Stopping execution.");
            	}else {
            		System.out.println("Could not open file "+ "$aktuelleDatei" + ". Stopping execution.");
            		//e.printStackTrace();
            	}
 
            } catch(NullPointerException NPEe) {

            	System.out.println("Could not open file "+ "$aktuelleDatei" + ". Stopping execution.");
            }
   
        }else{
            System.out.println("Gui starten");
        }
    }
}
