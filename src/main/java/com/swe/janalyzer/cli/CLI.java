package com.swe.janalyzer.cli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.analysis.Analyser;
import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.FileUtil;
import com.swe.janalyzer.util.IOExceptionWithFile;
import org.apache.commons.cli.*;

import com.swe.janalyzer.util.Constants;



public class CLI {

	/**
	 * Command Line Arguments werden ausgewertet
	 *
	 * @param arguments sind die Command Line Arguments die Uebergeben wurden sind
	 * @throws IOException
	 * @throws NullPointerException
	 * @throws ParseException falls eine falsche Eingabe in der Kommandozeile 
	 * getaetigt wird
	 */

	public int handle(String[] arguments) {

		CommandLineParser parser = new DefaultParser();
		CommandLine line = null;

		try {
			line = parser.parse(buildOptions(), arguments);
		} catch (ParseException e) {
		    handleParseExecption(e);
			return 1;
		}
		//Check help options
		if(line.hasOption("help") || line.hasOption("manual")){
			printHelpText();
			return 0;
		}

		String[] args = line.getArgs();
		if(args.length == 0) {
			System.out.println("Too few arguments. Stopping execution.");
			printHelpText();
			return 1;
		}else if(args.length > 1){
			System.out.println("Wrong argument count. Expected 1 argument, got " + args.length + ". Stopping execution.");
			printHelpText();
			return 1;
		}
		Path projectRoot = Paths.get(args[0]);

		//TODO Dieser Fall ist nicht im Lastenheft
		if(!FileUtil.validateFolder(projectRoot)){
			System.out.println("Path: " + projectRoot.toString() + " is not an existing directory. Stopping execution");
			return 1;
		}

		boolean verbose = line.hasOption("v");

		List<MetricResult> result = null;
		try {
			result = new Analyser().analyse(projectRoot, verbose);
		} catch (IOExceptionWithFile e) {
			System.out.println("Could not open file " + e.getFile().toString() + ". Stopping execution.");
			return 1;
		} catch (ParseProblemException e){
			System.out.println("There is a syntactical error in one of the project Files.\n"
					+ "Use a compiler for further information regarding the syntactic error");
			return 1;
		}
		if(verbose){
			System.out.println("All files analyzed");
		}

		final String projectName = projectRoot.getFileName().toString();
		Project project = new Project(projectName, result);

		if(line.hasOption("h")){
			//TODO Implement option
			System.out.println(result.toString());
			return 0;
		}

		// set output
		Path outputPath;
		if (line.hasOption("o")) {
			outputPath = Paths.get(line.getOptionValue("o"));
		}else{
		    //Calc correct output path
			//path is: user.home / project_name + _ + Count
			Path defaultDir = Constants.DEFAULT_OUTPUT_DIR();
			try {
				outputPath = Paths.get(defaultDir.toString(),
						projectName + "_" + FileUtil.analyzationNumber(projectRoot, defaultDir));
			} catch (IOException e) {
				System.out.println("Failed to get information how often the Project has been analysed.\n"
						+ "Please rename the result manualy");
				outputPath = Paths.get(defaultDir.toString(), projectName + "_X");
			}
		}

		if(verbose){
			System.out.println("Writing results to ​" + outputPath.toString());
		}

		//Create Parent directories if exists
		if (outputPath.getParent() != null){
			try {
				Files.createDirectories(outputPath.getParent());
			} catch (IOException e) {
				System.out.println("Could not write results to file with path: "
						+ outputPath.toString()
						+". Stopping execution.");
				return 1;
			}
		}

		try {
			JSONConverter.saveSummary(project, outputPath);
		} catch (IOException e) {
			System.out.println("Could not write results to file with path: "
					+ outputPath.toString()
					+". Stopping execution.");
			return 1;
		}

		return 0;
	}

	private void handleParseExecption(ParseException e) {
		if(e instanceof MissingArgumentException){
			System.out.println("Too few arguments. Stopping execution.");
			printHelpText();
		}else if(e instanceof AlreadySelectedException){
			System.out.println("Unsupported combination of options. Stopping execution.");
			printHelpText();
		}else if(e instanceof UnrecognizedOptionException){
			System.out.println("Unknown option. Stopping execution.");
			printHelpText();
		}else{
			System.out.println("Unknown Exception. Stopping execution. Please check the manual");
			System.out.println(e.getLocalizedMessage());
			printHelpText();
		}
	}

	private void printHelpText() {
	    List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("src/main/resources/cli_help_text.txt"));
		} catch (IOException e) {
			//This should NEVER happen
			System.out.println("Internal Error :(");
			return;
		}
		lines.forEach(System.out::println);
	}

	private Options buildOptions(){
		//DEFINE OPTIONS
		Option outputOption = Option.builder("o")
				.longOpt("output")
				.required(false)
				.hasArg(true)
				.numberOfArgs(1)
				.build();

		Option verboseOption = Option.builder("v")
				.longOpt("verbose")
				.required(false)
				.hasArg(false)
				.build();

		Option helpOption1 = Option.builder("manual")
				.longOpt("manual")
				.required(false)
				.hasArg(false)
				.build();
		Option helpOption2 = Option.builder("help")
				.longOpt("help")
				.required(false)
				.hasArg(false)
				.build();

		Option humanOption = Option.builder("h")
				.longOpt("human")
				.required(false)
				.hasArg(false)
				.build();


		Options options = new Options();
<<<<<<< HEAD
		options.addOption(outputOption);		
		options.addOption(verboseOption);		
		options.addOption(helpOption);		
		options.addOption(humanOption);
		
		try {
		
			OptionenVerarbeitung optVer = new OptionenVerarbeitung();
			
			//Prüfung, ob valide Option und nicht -h und -o gemeinsam			
			for(int i = 0; i < args.length; i++) {			
				if(args[i].startsWith("-")) {				
					if(options.hasShortOption(args[i]) || options.hasLongOption(args[i])) {					
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
					optVer.saveFileAtPath(line.getOptionValue("o"));
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
=======

		//Human and output are mutually exclusiv
		OptionGroup optGroup = new OptionGroup();
		optGroup.addOption(humanOption);
		optGroup.addOption(outputOption);
		options.addOptionGroup(optGroup);

		//ADD OPTIONS
		options.addOption(verboseOption);
		options.addOption(helpOption1);
		options.addOption(helpOption2);

		return options;
	}
>>>>>>> e98706bfb048372ff740048464924674f2d9c6c4
}