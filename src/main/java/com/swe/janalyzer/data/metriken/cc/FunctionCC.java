package com.swe.janalyzer.data.metriken.cc;

public class FunctionCC {
    private String funcName;
    private int ccValue;

    public FunctionCC(){}
    public FunctionCC(String funcName) {
        this.funcName = funcName;
    }

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
