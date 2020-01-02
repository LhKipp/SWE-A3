package com.swe.janalyzer.cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.swe.janalyzer.App;
import com.swe.janalyzer.util.Constants;
//import com.swe.janalyzer.storage.*;
//import com.swe.janalyzer.data.metriken.Summary;

/**
 * Optionen werden verarbeitet
 */
public class OptionenVerarbeitung {

	public static boolean verboseIsSet = false;
	public static boolean allFilesAnalyzed = false;
	
	/**
	 * Der Outputpfad wird vom Benutzer gesetzt
	 * @param filePath ist der Outputpfad der in der Command Line mit gegeben wird.
	 * @throws NullPointerException 
	 */
	public void saveFileAtPath (String filePath) throws NullPointerException  {
		File file = new File(filePath);
		boolean isDirectory = file.isDirectory();//Check if it's a directory
		
		if(isDirectory) {
			Constants.outputPath = file.toPath();
		}else {
			file.mkdir();
			System.out.println(file.toString());
			Constants.outputPath = file.toPath();
		}
	}

	/**
	 * Verbose wird gesetzt, um es dann weiter zu verwerten Ausgabe des Programmsablauf
	 * @return verboseIsSet
	 */
	public boolean verboseSet() {
		verboseIsSet = true;

		return verboseIsSet;
	}

}
