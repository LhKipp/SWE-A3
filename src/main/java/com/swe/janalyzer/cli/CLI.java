package com.swe.janalyzer.cli;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;

public class CLI {

	/**
	 * Command Line Arguments werden ausgewertet
	 * 
	 * @param args sind die Command Line Arguments die übergeben wurden sind
	 * @throws ParseException falls eine falsche Eingabe in der Kommandozeile 
	 * getätigt wird
	 */
	
	public void cli(String[] args) {

		CommandLineParser parser = (CommandLineParser) new DefaultParser();

		 Options options = new Options();

		// add options
		options.addOption("o", "output", true, 
				"Der Speicherort der, vom Programm erzeugten Analysedaten wird zu $speicherpfad"
						+ "geändert. Falls diese Option nicht beim Aufruf des Programms genutzt wird, ist der\r\n"
						+ "Speicherort:\r\n" + "$user.home/java_analyzer/$Projektname_X\r\n"
						+ "$user.home ist hierbei das Benutzerverzeichnis des Benutzers, welcher das Programm "
						+ "aufgerufen hat.\r\n"
						+ "$Projektname_X ist hierbei der Name des Projektordners, gefolgt von einem Unterstrich"
						+ "und einer natürlichen Zahl inklusive 0 (X ∈ 𝑁), um Duplikate bei mehrmaliger Analyse"
						+ "des gleichen Projektes zu vermeiden.\r\n\n");
		options.addOption("v", "verbose", false,
				"Das Programm gibt nach standard-out einzelne Schritte des Programmablaufes aus.\r\n"
						+ "Die Ausgaben sind:\r\n" + "1. Processing file $file_path\r\n"
						+ "Erklärung: Das Programm errechnet die Metriken für die Datei mit Pfad $file_path .\r\n"
						+ "2. All files analyzed\r\n"
						+ "Erklärung: Das Programm hat alle Programmdateien des Projektes analysiert.\r\n"
						+ "3. Writing results to $output_file\r\n" + "40\r\n"
						+ "Erklärung: Das Programm schreibt die Ergebnisse in die Datei unter dem Pfad\r\n"
						+ "$output_file .");
//		options.addOption("help", "manual", false,
//				"Das Programm gibt nach standard-out eine Bedienungshilfe aus und beendet die Ausführung.");

		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);
			OptionenVerarbeitung optVer = new OptionenVerarbeitung();

				if (line.hasOption("o")) {
					// add save path
					Path filePath = Paths.get(line.getOptionValue("o"));
					optVer.saveFileAtPath(filePath);
				} else if (line.hasOption("v")) {
					// set Verbose
					optVer.verboseSet();

				} else if (line.hasOption("help")) {
					//optVer.manual();
					HelpFormatter help = new HelpFormatter();
					help.printHelp("janalayzer [optionen] [projektpfad]\n", options);
				}
			
		} catch (ParseException exp) {
			// oops, something went wrong
			System.out.println( "Unexpected exception:" + exp.getMessage() );
		}

	}

}
