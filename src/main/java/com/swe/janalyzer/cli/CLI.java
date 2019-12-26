package com.swe.janalyzer.cli;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.CommandLineParser;

public class CLI {

	/**
	 * Command Line Arguments werden ausgewertet
	 * 
	 * @param args sind die Command Line Arguments die Uebergeben wurden sind
	 * @throws IOException 
	 * @throws NullPointerException 
	 * @throws ParseException falls eine falsche Eingabe in der Kommandozeile 
	 * getÃ¤tigt wird
	 */
	
	public void cli(String[] args) throws NullPointerException, IOException {

		CommandLineParser parser = (CommandLineParser) new DefaultParser();

		//DEFINE OPTIONS
		Option outputOption = Option.builder("o")
		          .longOpt("output")
		          .required(false)
		          .hasArg(true)
		          .numberOfArgs(1)
		          .desc("Der Speicherort der, vom Programm erzeugten Analysedaten wird zu $speicherpfad" + 
		          		" geaendert. Falls diese Option nicht beim Aufruf des Programms genutzt wird, ist der" + 
		          		" Speicherort:\r\n" + "$user.home/java_analyzer/$Projektname_X\r\n" + 
		          		" $user.home ist hierbei das Benutzerverzeichnis des Benutzers, welcher das Programm \"\r\n" + 
		          		" aufgerufen hat.\r\n" + 
		          		" $Projektname_X ist hierbei der Name des Projektordners, gefolgt von einem Unterstrich" + 
		          		" und einer natuerlichen Zahl inklusive 0 (), um Duplikate bei mehrmaliger Analyse" + 
		          		" des gleichen Projektes zu vermeiden.")
		          .build();
	
		Option verboseOption = Option.builder("v")
		          .longOpt("verbose")
		          .required(false)
		          .hasArg(false)
		          .numberOfArgs(1)
		          .desc("Das Programm gibt nach standard-out einzelne Schritte des Programmablaufes aus.\r\n" + 
		          		"Die Ausgaben sind:\r\n "+
		          		"1. Processing file $file_path\r\n" + 
		          		"Erklaerung: Das Programm errechnet die Metriken für die Datei mit Pfad $file_path.\r\n\n" + 
		          		"2. All files analyzed\r\n" + 
		          		"Erklaerung: Das Programm hat alle Programmdateien des Projektes analysiert.\r\n\n" + 
		          		"3. Writing results to $output_file\r\n" + 
		          		"Erklaerung: Das Programm schreibt die Ergebnisse in die Datei unter dem Pfad" + 
		          		"$output_file.")
		          .build();
		 
		 Option helpOption = Option.builder("h")
		          .longOpt("help")
		          .required(false)
		          .hasArg(false)
		          .numberOfArgs(0)
		          .desc("Das Programm gibt nach standard-out eine Bedienungshilfe aus und beendet die Ausfuehrung.")
		          .build();
		 
		 //ADD OPTIONS
		 Options options = new Options();
		 
		 options.addOption(outputOption);
		 options.addOption(verboseOption);
		 options.addOption(helpOption);
		 
		 CommandLine line = null;
		 HelpFormatter falseInput = new HelpFormatter();
		 
		try {
			// parse the command line arguments
			line = parser.parse(options, args);
			OptionenVerarbeitung optVer = new OptionenVerarbeitung();

			System.out.println("BinDA: "+ args.length);
				if (line.hasOption("o")) {
					if(args.length == 3) {
						Path filePath = Paths.get(line.getOptionValue("o"));
						optVer.saveFileAtPath(filePath);
					}else {
						throw new ParseException("");
					}//Falls Pfad nicht mit angegeben dann throw
					
				} else if (line.hasOption("v")) {
					// set Verbose
					if(args.length == 2) {
						optVer.verboseSet();
					}else {
						throw new ParseException("");
					}//Falls Pfad nicht mit angegeben dann throw
					

				} else if (line.hasOption("help")) {
					//optVer.manual();
					HelpFormatter help = new HelpFormatter();
					help.printHelp("janalayzer [optionen] [projektpfad]\n", options);
				} 
				
			
		} catch (ParseException exp) {
			// oops, something went wrong
			if(args.length < 3) {
				falseInput.printHelp("Too few arguments. Stopping execution.\n" 
					+ "janalayzer [optionen] [projektpfad]\n\n",options);
			}else if(args.length > 3) {
				falseInput.printHelp("Wrong argument count. Expected 1 argument, got " + args.length + ". Stopping execution.\n" 
						+ "janalayzer [optionen] [projektpfad]\n\n",options);
			}	
		}
	}

}
