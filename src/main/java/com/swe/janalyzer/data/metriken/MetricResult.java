package com.swe.janalyzer.data.metriken;

import java.util.Map;

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
}
