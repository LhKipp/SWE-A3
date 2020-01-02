package com.swe.janalyzer.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Eine Klasse für alle systemweiten Konstanten.
 */
public class Constants {
		public static final String SEPERATOR = "@=@";

	public static final String GENERAL_KEY = "VALUE";
	public static final String MAX_POSTFIX = " Max";
	public static final String CUMULATED_POSTFIX = " Cumulated";
	public static final String LOC = "LOC";
	public static final String LOC_CUM = LOC + CUMULATED_POSTFIX;
	public static final String CC = "CC";
	public static final String CC_MAX = CC + MAX_POSTFIX;
	public static final String DIT = "DIT";
	public static final String DIT_MAX = DIT + MAX_POSTFIX;
	public static final String WMC = "WMC";
	public static final String WMC_MAX = WMC + MAX_POSTFIX;

		public static final String DEFAULT_PATH = "default";
		public static final String CUSTOM_PATH = "custom";
		public static final Path OPTION_PATH = Paths.get("./output/options.json");
}
