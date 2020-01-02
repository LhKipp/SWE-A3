package com.swe.janalyzer.analysis.util;

import com.swe.janalyzer.data.metriken.MetricResult;

import java.util.HashMap;

public class Util {

    public static <K> MetricResult metricOfBasicValue(
           final String metricName
            , final String keyName
            , final K value
            , boolean represantableInBarChart){
        HashMap<String, String> r = new HashMap<>(1);
        r.put(keyName, value.toString());
        return new MetricResult(metricName, r, represantableInBarChart);
    }
}
