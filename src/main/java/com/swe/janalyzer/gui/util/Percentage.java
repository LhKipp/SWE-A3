package com.swe.janalyzer.gui.util;

import java.text.NumberFormat;

public class Percentage {


    public static String formatAsPercentage(double value){
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return nf.format(value);
    }
}
