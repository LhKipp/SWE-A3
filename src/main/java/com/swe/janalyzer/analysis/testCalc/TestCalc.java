package com.swe.janalyzer.analysis.testCalc;

import com.github.javaparser.ast.CompilationUnit;
import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.util.Util;
import com.swe.janalyzer.data.metriken.MetricResult;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class TestCalc implements MetricCalculator {
    @Override
    public void calcResultsFor(Path path, String code, CompilationUnit cu) {

    }

    @Override
    public List<MetricResult> getResults() {
        return Collections.singletonList(Util.metricOfBasicValue("TEST", "VALUE", 3, true));
    }

    @Override
    public List<MetricResult> getCalculatedMetrics() {
        return Collections.singletonList(Util.metricOfBasicValue("TEST", "VALUE", 3, true));
    }

    @Override
    public void clear() {

    }
}
