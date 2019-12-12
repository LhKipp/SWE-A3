package com.swe.janalyzer.analysis.cc;

import com.github.javaparser.ast.visitor.VoidVisitor;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.util.ClassSpecifier;

import java.util.Map;

public class CCCalculator {

    private Map<ClassSpecifier, ClassMetrics> classMetrics;

    public CCCalculator(Map<ClassSpecifier, ClassMetrics> classMetrics) {
        this.classMetrics = classMetrics;
    }

    public VoidVisitor<Void> getASTVisitor() {
        return new CCVisitor(classMetrics);
    }
}
