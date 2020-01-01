package com.swe.janalyzer;

import com.swe.janalyzer.analysis.Analyser;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.ClassSpecifier;
import com.swe.janalyzer.util.IOExceptionWithFile;
import com.swe.janalyzer.util.Options;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JSONConverterTest {
		private List<MetricResult> results;
		private Options options;

		@Before
		public void init() throws IOException, IOExceptionWithFile {
		    results = new Analyser().analyse(Paths.get("Testdateien/preferences"));
		}

		@Test
		public void testSaveSummary(){
				try {
						JSONConverter.saveSummary(results, Paths.get("testSave.json"));
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.saveSummary(results, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}
		}

		@Test
		public void testLoadSummary() throws IOException {
			try {
				JSONConverter.saveSummary(results, Paths.get("testSave.json"));
			} catch (IOException ioe) {
				fail("IOException wasn't expected.");
			} catch (NullPointerException ne) {
				fail("NullPointerException wasn't expected.");
			}
			List<MetricResult> metricResults = JSONConverter.loadSummary(Paths.get("testSave.json"));
			assertTrue(metricResults.equals(results));
		}

		@Test
		public void testSaveOptions() {
				try {
						JSONConverter.saveOptions(options);
				} catch (IOException io) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne){
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.saveOptions(null);
						fail("NullPointerException was expected.");
				} catch (IOException io) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne){
				}
		}

		@Test
		public void testLoadOptions() {
				try {
						JSONConverter.saveOptions(options);
				} catch (IOException e) {
						fail("IOException wasn't expected.");
				}

				try {
						Options option = JSONConverter.loadOptions();
						option.equals(options);
				} catch (IOException e) {
						fail("IOException wasn't expected.");
				}
		}
}
