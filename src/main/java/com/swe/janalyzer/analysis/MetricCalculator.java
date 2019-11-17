package com.swe.janalyzer.analysis;

import com.swe.janalyzer.data.metriken.Summary;

import java.nio.file.Path;

public interface MetricCalculator {

    Summary calculate(Path projectRoot);
}
