package com.swe.janalyzer.cli;

import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Project;

import java.util.List;

public class HumanOpt {

    public static void print(final Project project){
        List<MetricResult> analysedMetrics = project.getAnalysedMetrics();

        for(MetricResult r : analysedMetrics){
            r.getResults()
                    .forEach((key, value) -> System.out.println(r.getMetricName() + " " + key + ": " + value));
            //Print Empty line
            System.out.println();
        }

    }
}
