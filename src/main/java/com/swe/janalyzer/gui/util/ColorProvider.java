package com.swe.janalyzer.gui.util;

import javafx.scene.paint.Color;

public class ColorProvider {
    public static String[] colors ={
            "#3E4861",
            "#89C26B",
            "#A3CCCC",
            "#DACDA7",
            "#F2A46B",
            "#D5835E",
            "#594153",
            "#F5C372",
            "#5B1A31",
            "#55D1D2",
            "#49C172",
            "#5F455F"
    };

    private int index = -1;

    public String next(){
        index = index +1  < colors.length ? index +1 : 0;
        return colors[index];
    }
}
