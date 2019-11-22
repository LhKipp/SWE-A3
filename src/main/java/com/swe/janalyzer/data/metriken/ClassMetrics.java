package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.data.metriken.cc.FunctionCC;

import java.util.List;

public class ClassMetrics {
   private int dit;

   private List<FunctionCC> functionCCs;

   public ClassMetrics() {
   }

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

   public void setFunctionCCs(List<FunctionCC> functionCCs) {
      this.functionCCs = functionCCs;
   }

}
