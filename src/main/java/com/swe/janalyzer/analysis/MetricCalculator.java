package com.swe.janalyzer.analysis;

import com.github.javaparser.ast.CompilationUnit;
import com.swe.janalyzer.data.metriken.MetricResult;

import java.nio.file.Path;
import java.util.List;

public interface MetricCalculator{
    /**
     * calculates the metrics for one project file described by path.
     *
     * @param path - The file
     * @param code - the content of the file
     * @param cu - the content of the file as an AST
     */
    public void calcResultsFor(Path path,String code, CompilationUnit cu);



    /**
     * Returns the calculated results over all files since the last call to clear or since construction
     * @return A list of calculated Metrics for the last files
     */
    public List<MetricResult> getResults();

    /**
     * Clears all calculated results which have been gathered from the last files
     */
    public void clear();
}
