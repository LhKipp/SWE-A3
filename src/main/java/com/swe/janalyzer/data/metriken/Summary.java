package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.util.ClassSpecifier;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Simple Struct holding all metrics
 */
public class Summary {
    private List<FileMetrics> fileMetrics;
    private Map<ClassSpecifier, ClassMetrics> classMetrics;

    public Summary() {
    }

    public List<FileMetrics> getFileMetrics() {
        return fileMetrics;
    }

    public void setFileMetrics(List<FileMetrics> fileMetrics) {
        this.fileMetrics = fileMetrics;
    }

    public Map<ClassSpecifier, ClassMetrics> getClassMetrics() {
        return classMetrics;
    }

    public void setClassMetrics(Map<ClassSpecifier, ClassMetrics> classMetrics) {
        this.classMetrics = classMetrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(fileMetrics, summary.fileMetrics) &&
                Objects.equals(classMetrics, summary.classMetrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileMetrics, classMetrics);
    }
}

