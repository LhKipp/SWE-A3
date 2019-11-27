package com.swe.janalyzer.data.metriken.cc;

/**
 * Datenmodell für die Metriken einer Funktion.
 * {@link FunctionCC#funcName} ist der Name der Funktion.
 * {@link FunctionCC#ccValue} ist der errechnete MacCabe-Wert für die Funktion.
 */
public class FunctionCC {
    private String funcName;
    private int ccValue;

    public FunctionCC(){
    }

    /**
     * Konstruktor initialisiert den Namen der Funktion mit dem, vom Benutzer übergebenen Paramter.
     * {@link FunctionCC#ccValue} ist 0.
     * @param funcName der Name der Funktion
     */
    public FunctionCC(String funcName) {
        this.funcName = funcName;
    }

    /**
     * Konstruktor initialisiert alle Attribute mit den, vom Benutzer übergebenen Parametern.
     * @param funcName der Name der Funktion
     * @param ccValue der MacCabe-Wert der Funktion
     */
    public FunctionCC(String funcName, int ccValue) {
        this.funcName = funcName;
        this.ccValue = ccValue;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public int getCCValue() {
        return ccValue;
    }

    public void setCCValue(int ccValue) {
        this.ccValue = ccValue;
    }
}
