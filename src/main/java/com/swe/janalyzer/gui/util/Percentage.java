package com.swe.janalyzer.gui.util;

public class Percentage {


    public static String formatAsPercentage(double value){
        final String v = Double.toString(value * 100);
        final int lastDigit = 5 < v.length() ? 5 : v.length();
        return v.substring(0, lastDigit) + "%";
    }
}
