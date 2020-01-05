package com.swe.janalyzer.data.metriken;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MetricResult {

    /**
     * Unique identifier
     */
    private String metricName;
    //For cc
    // key = ClassName::functionName, value = ccValue
    //For loc
    // key = fileName, value = locValue
    //For dit
    // key = className, value = ditValue
    //For wmc
    // key = className, value = wmcValue
    private Map<String, String> results;
    private boolean represantableInBarChart;
    private boolean hasNumericalValues;

    public MetricResult(){
        this("", new HashMap<>(), false);
    };
    public MetricResult(String metricName, boolean represantableInBarChart, boolean hasNumericalValues){
        this(metricName, new HashMap<>(), represantableInBarChart, hasNumericalValues);
    }

    public MetricResult(String metricName, Map<String, String> results) {
        this(metricName, results, false);
    }
    public MetricResult(String metricName, Map<String, String> results, boolean represantableInBarChart) {
        this(metricName, results, represantableInBarChart, true);
    }

    public MetricResult(String metricName, Map<String, String> results, boolean represantableInBarChart, boolean hasNumericalValues) {
        this.metricName = metricName;
        this.results = results;
        this.represantableInBarChart = represantableInBarChart;
        this.hasNumericalValues = hasNumericalValues;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetricResult that = (MetricResult) o;
        return Objects.equals(metricName, that.metricName) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metricName, results);
    }

    public boolean isRepresantableInBarChart() {
        return represantableInBarChart;
    }

    public double getFirstResultAsDouble(){
        if(results.isEmpty()){
            return 0;
        }
        try {
            return Double.parseDouble(results.values().iterator().next());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public boolean isHasNumericalValues() {
        return hasNumericalValues;
    }

    public void setHasNumericalValues(boolean hasNumericalValues) {
        this.hasNumericalValues = hasNumericalValues;
    }
}
