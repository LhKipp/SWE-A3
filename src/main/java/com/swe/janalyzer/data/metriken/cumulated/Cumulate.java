package com.swe.janalyzer.data.metriken.cumulated;

import com.swe.janalyzer.data.metriken.Summary;

public interface Cumulate {
		CumulatedMetrics cumulate(Summary summary);
}
