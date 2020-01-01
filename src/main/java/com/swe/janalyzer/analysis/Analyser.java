package com.swe.janalyzer.analysis;

import com.github.javaparser.ParseProblemException;
import com.swe.janalyzer.data.metriken.MetricResult;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Top
 */
public class Analyser {
    private List<MetricCalculator> metricCalculators;

    Analyser(){
        //Default Metrics to calculate
        //metricCalculators.add(new CCCalculator);
        //...
    }

    /**
     * This method invokes every MetricCalculator added to metricCalculators list and returns their
     * results bundled into one list.
     * @param projectRoot - the root directory of the project
     * @return Every Metric calculated by the MetricCalculators
     * @throws IOException - If any file in the Project couldnt be opened
     * @throws ParseProblemException - If any file in the Project is ill formed
     */
    public List<MetricResult> analyse(Path projectRoot) throws IOException, ParseProblemException{
        //TODO implementation
        return null;
    }

    public List<MetricCalculator> getMetricCalculators() {
        return metricCalculators;
    }

    public void setMetricCalculators(List<MetricCalculator> metricCalculators) {
        this.metricCalculators = metricCalculators;
    }
}
