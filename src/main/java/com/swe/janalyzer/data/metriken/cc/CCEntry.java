package com.swe.janalyzer.data.metriken.cc;

import com.swe.janalyzer.util.ClassSpecifier;

import java.util.ArrayList;
import java.util.List;

public class CCEntry {
    private ClassSpecifier clazz;
    private List<FunctionCC> functions = new ArrayList<>();

    public CCEntry() {}
    public CCEntry(ClassSpecifier clazz, int estimatedFuncCount) {
        this.clazz = clazz;
        this.functions = new ArrayList<>(estimatedFuncCount);
    }

    public ClassSpecifier getClazz() {
        return clazz;
    }

    public void setClazz(ClassSpecifier clazz) {
        this.clazz = clazz;
    }

    public List<FunctionCC> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionCC> functions) {
        this.functions = functions;
    }
}
