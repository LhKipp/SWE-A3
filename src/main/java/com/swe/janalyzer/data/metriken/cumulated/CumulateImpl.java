package com.swe.janalyzer.data.metriken.cumulated;

import com.swe.janalyzer.data.metriken.Summary;

public class CumulateImpl implements Cumulate {

		//TODO Kummulation implementieren!
		@Override
		public CumulatedMetrics cumulate(Summary summary) {
				return new CumulatedMetrics();
		}
}
