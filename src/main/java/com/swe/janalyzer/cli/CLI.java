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

		Project result = null;
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

		if(line.hasOption("h")){
			HumanOpt.print(result);
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
						result.getName() + "_" + FileUtil.analyzationNumber(projectRoot, defaultDir));
			} catch (IOException e) {
				System.out.println("Failed to get information how often the Project has been analysed.\n"
						+ "Please rename the result manualy");
				outputPath = Paths.get(defaultDir.toString(), result.getName() + "_X");
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
			JSONConverter.saveSummary(result, outputPath);
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
}