package com.swe.janalyzer.data.metriken;

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

    public MetricResult(String metricName, Map<String, String> results) {
        this.metricName = metricName;
        this.results = results;
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
}
