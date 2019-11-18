package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.util.ClassSpecifier;

import java.util.List;
import java.util.Map;

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
}

