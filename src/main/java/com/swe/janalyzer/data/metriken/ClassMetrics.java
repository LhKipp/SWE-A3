package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.data.metriken.cc.FunctionCC;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Datenmodell für die Metriken einer Klasse.
 */
public class ClassMetrics {
    private int dit;
    private List<FunctionCC> functionCCs;
    public ClassMetrics() { }

    public ClassMetrics(int dit) {
        this.dit=dit;
    }

    public ClassMetrics(List<FunctionCC> functionCCs) {
        this.functionCCs = functionCCs;
    }

    public int getDit() {
        return dit;
    }

    public void setDit(int dit) {
        this.dit = dit;
    }

    public List<FunctionCC> getFunctionCCs() {
        return functionCCs;
    }

    /**
        * Setter für {@link ClassMetrics#functionCCs}
        * @param functionCCs
     */
    public void setFunctionCCs(List<FunctionCC> functionCCs) {
        this.functionCCs = functionCCs;
    }

    public int getWmcValue() {
        return functionCCs.stream()
            .mapToInt(FunctionCC::getCCValue)
            .sum();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassMetrics that = (ClassMetrics) o;
        return dit == that.dit &&
            Objects.equals(functionCCs, that.functionCCs);
    }

    @Override
    public int hashCode(){
        return Objects.hash(dit, functionCCs);
    }
}
