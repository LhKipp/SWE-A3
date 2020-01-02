package com.swe.janalyzer.data.metriken;

import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private List<MetricResult> analysedMetrics;


    public Project(String projectName, List<MetricResult> analysedMetrics) {
        this.name = projectName;
        this.analysedMetrics = analysedMetrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MetricResult> getAnalysedMetrics() {
        return analysedMetrics;
    }

    public void setAnalysedMetrics(List<MetricResult> analysedMetrics) {
        this.analysedMetrics = analysedMetrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(analysedMetrics, project.analysedMetrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, analysedMetrics);
    }
}
