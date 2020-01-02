package com.swe.janalyzer.cli;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

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

public class CliTest {

	//Korrekte Eingaben
	private String[] cmd1 = {"C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd2 = {"--help"};
	private String[] cmd3 = {"-o", "C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub" ,"C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd4 = {"-v","C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	//Fehlerhafte Eingaben
	private String[] cmd5 = {"C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub" ,"C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd6 = {"-o","C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd7 = {"-k", "C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd8 = {"-h", "-o", "C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub" ,"C:\\Users\\Nakabayashi\\Documents\\FHAachen\\GitHub\\Test"};
	private String[] cmd9 = {"Code\\MyProject"};
	private String[] cmd10 = {};
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
