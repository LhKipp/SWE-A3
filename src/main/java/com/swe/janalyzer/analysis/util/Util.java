package com.swe.janalyzer.analysis.util;

import com.swe.janalyzer.data.metriken.MetricResult;

import java.util.Collections;
import java.util.HashMap;

public class Util {

    public static <K> MetricResult metricOfBasicValue(
           final String metricName
            , final String keyName
            , final K value
            , boolean represantableInBarChart){
        return new MetricResult(metricName
                , Collections.singletonMap(keyName, value.toString())
                , represantableInBarChart);
    }
}
