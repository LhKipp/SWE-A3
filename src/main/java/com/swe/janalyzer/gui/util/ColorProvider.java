package com.swe.janalyzer.gui.util;

import javafx.scene.paint.Color;

public class ColorProvider {
    public static String[] colors ={
            "#3E4861",
            "#89C26B",
            "#A3CCCC",
            "#DACDA7",
            "#F2A46B"
    };

    private int index = -1;

    public String next(){
        index = index +1  < colors.length ? index +1 : -1;
        return colors[index];
    }
}
