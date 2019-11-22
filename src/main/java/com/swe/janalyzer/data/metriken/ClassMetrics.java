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
    * Im Anschluss wird der wmc berechnet, der sich aus der Summe des MacCabe der einzelnen Methoden zusammensetzt
    * @param functionCCs
    */
   public void setFunctionCCs(List<FunctionCC> functionCCs) {
      this.functionCCs = functionCCs;
      for(FunctionCC curFunction : this.functionCCs) {
         wmcValue += curFunction.getCCValue();
      }
   }

   public int getWmcValue() {
      return wmcValue;
   }

}
