package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.data.metriken.cc.FunctionCC;

import java.util.ArrayList;
import java.util.List;

/**
 * Datenmodell für die Metriken einer Klasse.
 */
public class ClassMetrics {
   private int dit;
   private List<FunctionCC> functionCCs;
   private int wmcValue;

   public ClassMetrics() {
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

}
