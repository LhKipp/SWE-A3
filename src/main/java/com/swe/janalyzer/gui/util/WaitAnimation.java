package com.swe.janalyzer.gui.util;


import javafx.scene.control.TextField;

public class WaitAnimation extends TextField {

    private int dots = 2;
    private String text = "";
    public WaitAnimation() {
        setText(".");
    }

    public WaitAnimation(String text) {
        this.text = text;
        setText(text + ".");
    }

    public void nextState(){
       switch (dots){
           case 1:
               setText(text + ".");
               break;
           case 2:
               setText(text + "..");
               break;
           case 3:
               setText(text + "...");
               break;
       }
       dots = dots + 1 <= 3 ? dots + 1 : 1;
    }

    public void reset() {
        setText(text + ".");
        dots = 2;
    }
}
