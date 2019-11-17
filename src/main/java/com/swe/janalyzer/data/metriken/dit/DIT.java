package com.swe.janalyzer.data.metriken.dit;

import com.swe.janalyzer.util.ClassSpecifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIT {
    private Map<ClassSpecifier, Integer> entries;

    public DIT(){}

    public Map<ClassSpecifier, Integer> entries(){
        return entries;
    }
    public void setEntries(Map<ClassSpecifier, Integer> entries){
        this.entries = entries;
    }
}
