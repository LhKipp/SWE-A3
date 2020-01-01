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

import com.swe.janalyzer.util.Constants;



public class CLI {

	/**
	 * Command Line Arguments werden ausgewertet
	 * 
	 * @param args sind die Command Line Arguments die Uebergeben wurden sind
	 * @throws IOException 
	 * @throws NullPointerException 
	 * @throws ParseException falls eine falsche Eingabe in der Kommandozeile 
	 * getaetigt wird
	 */
	
	public void cli(String[] args) {

		CommandLineParser parser = (CommandLineParser) new DefaultParser();
		CommandLine line = null;
		HelpFormatter falseInput = new HelpFormatter();
		boolean notAceptedCombi = false;
		boolean outputIsSet = false;
		boolean humanIsSet = false;
		boolean noProjectPath = false;

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
				.numberOfArgs(0)				
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
				 
		Option helpOption = Option.builder("help")		
				.longOpt("manual")				
				.required(false)				
				.hasArg(false)				
				.numberOfArgs(0)				
				.desc("Das Programm gibt nach standard-out eine Bedienungshilfe aus und beendet die Ausfuehrung.")				
				.build();
				 
		Option humanOption = Option.builder("h")		
				.longOpt("human")				
				.required(false)				
				.hasArg(false)				
				.numberOfArgs(0)				
				.desc("Das Programm gibt Menschenlesbare Infos")				
				.build();
				 
				 
		//ADD OPTIONS		
		Options options = new Options();
		options.addOption(outputOption);		
		options.addOption(verboseOption);		
		options.addOption(helpOption);		
		options.addOption(humanOption);
		
		try {
		
			OptionenVerarbeitung optVer = new OptionenVerarbeitung();
			
			//Prüfung, ob valide Option und nicht -h und -o gemeinsam			
			for(int i = 0; i < args.length; i++) {			
				if(args[i].startsWith("-")) {				
					if(options.hasShortOption(args[i])) {					
						if(args[i].compareTo("-h") == 0) {						
							//continue							
							humanIsSet = true;							
						}else if(args[i].compareTo("-o") == 0) {						
							//continue							
							outputIsSet = true;							
						}						
					}else {					
						throw new IllegalArgumentException();						
					}					
					for(int j = i+1; j < args.length; j++) {					
						if(outputIsSet && args[j].compareTo("-h") == 0 ) {						
							notAceptedCombi = true;							
							throw new IllegalArgumentException();							
						}else if(humanIsSet && args[j].compareTo("-o") == 0) {						
							notAceptedCombi = true;							
							throw new IllegalArgumentException();							
						}
					}
				}
			}
			
			// parse the command line arguments			
			line = parser.parse(options, args);
			
			// set output			
			if (line.hasOption("o")) {			
				if(!(line.getArgList().isEmpty())) {				
					Path filePath = Paths.get(line.getOptionValue("o"));					
					optVer.saveFileAtPath(filePath);					
				}else {				
					noProjectPath = true;					
					throw new ParseException("");					
				}					
			}/*end -o IF*/
				
			// set verbose				
			if (line.hasOption("v")) {			
				if(!(line.getArgList().isEmpty())) {				
					optVer.verboseSet();					
				}else {				
					noProjectPath = true;					
					throw new ParseException("");					
				}						
			}/*end -v IF*/
			
			//TEST für set human			
			if (line.hasOption("h")) {
				System.out.println("human ist gesetzt");					
			}/*end -h IF*/
			
			//set help			
			if (line.hasOption("help")) {			
				HelpFormatter help = new HelpFormatter();				
				help.printHelp("janalayzer [optionen] [projektpfad]\n", options);				
			}/*end -help IF*/
			
			//register ProjectRoot			
			for(String rest : line.getArgs()) {			
				if(line.getArgs().length == 1) {				
					Constants.projectRoot = Paths.get(rest);					
				}else {				
					throw new ParseException("");					
				}	
			}
			
		} catch (ParseException exp) {
			// oops, something went wrong
			if(noProjectPath) {
				falseInput.printHelp("Too few arguments. Stopping execution.\n" 				
						+ "janalayzer [optionen] [projektpfad]\n\n",options);
				}else{	
					falseInput.printHelp("Wrong argument count. Expected 1 argument, got " + line.getArgs().length + ". Stopping execution.\n"					
							+ "janalayzer [optionen] [projektpfad]\n\n",options);				
				}
									
		} catch (IllegalArgumentException iAexp) {
			
			// oops, something went wrong		
			if(notAceptedCombi) {			
				falseInput.printHelp("Unsupported combination of options. Stopping execution.\n" 				
						+ "janalayzer [optionen] [projektpfad]\n\n",options);
				}else {							
					falseInput.printHelp("Unknown option. Stopping execution.\n" 					
							+ "janalayzer [optionen] [projektpfad]\n\n",options);
				}	
			}	
		}	
}