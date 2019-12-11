package com.swe.janalyzer.analysis;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.util.ClassSpecifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Util {


    public static boolean equals(Summary calculated, Summary expected){
//        if(!calculated.getFileMetrics().containsAll(expected.getFileMetrics())){
//            return false;
//        }

        for (Map.Entry<ClassSpecifier, ClassMetrics> entry : expected.getClassMetrics().entrySet()){
            ClassSpecifier k = entry.getKey();
            ClassMetrics v = entry.getValue();
            if(!calculated.getClassMetrics().containsKey(k)){
                System.out.println("Expected class " + k.getAsString() + " not found.");
                System.out.println("For class " + k.getAsString());
                return false;
            }

            if(!(v.getDit() == calculated.getClassMetrics().get(k).getDit())){
                System.out.println("Expected dit " + v.getDit() + ", calculated: " + calculated.getClassMetrics().get(k).getDit());
                System.out.println("For class " + k.getAsString());
                return false;
            }
            for (FunctionCC functionCC : calculated.getClassMetrics().get(k).getFunctionCCs()) {
                Optional<FunctionCC> expCC = v.getFunctionCCs().stream().filter(f -> f.getFuncName().equals(functionCC.getFuncName()))
                        .findAny();
                if(!expCC.isPresent()){
                    System.out.println("Method calc but not expected: " + functionCC.getFuncName());
                    System.out.println("For class " + k.getAsString());
                    return false;
                }
                if(expCC.get().getCCValue() != functionCC.getCCValue()){
                    System.out.println("Exp cc: " + expCC.get().getCCValue() + "calc CC :" + functionCC.getCCValue());
                    System.out.println("For class " + k.getAsString());
                    System.out.println("Method " + functionCC.getFuncName());
                    return false;
                }
            }
            if(!calculated.getClassMetrics().get(k).getFunctionCCs().containsAll(v.getFunctionCCs())){
                System.out.println("Different methods found");
                System.out.println("Calculated methods: " + calculated.getClassMetrics().get(k)
                        .getFunctionCCs().stream().map(FunctionCC::getFuncName).collect(Collectors.toList()));
                System.out.println("Expected methods: " +
                        v.getFunctionCCs().stream().map(FunctionCC::getFuncName).collect(Collectors.toList()));
                return false;
            }
            if(!(v.getWmcValue() == calculated.getClassMetrics().get(k).getWmcValue())){
                System.out.println("Expected wmc " + v.getWmcValue() + ", calculated: " + calculated.getClassMetrics().get(k).getWmcValue());
                System.out.println("For class " + k.getAsString());
                System.out.println("Expected Functions: ");
                return false;
            }
        }
        return true;
    }
}
