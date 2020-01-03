package com.swe.janalyzer.gui;

public class OptionModel {

	int LOC = 0;
	int DIT = 0;
	int CC = 0;
	int WMC = 0;
	
	String defaultName;
	String defaultPath;
	String altName;
	String altPath;
	
	String printOut() {
		return ("LOC: " + Integer.toString(LOC) +
				"DIT: " + Integer.toString(DIT) +
				"CC: " + Integer.toString(CC) + 
				"WMC: " + Integer.toString(WMC));
	}
}
