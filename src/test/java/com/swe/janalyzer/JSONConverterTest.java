package com.swe.janalyzer;

import com.swe.janalyzer.analysis.Analyser;
import com.swe.janalyzer.data.metriken.*;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.IOExceptionWithFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class JSONConverterTest {
	public static final Path output_path = Paths.get("Trees.json");
	public static final Path PROJECT_ROOT = Paths.get("Testdateien/Trees");
	private Project results;

	@Before
	public void init() throws IOException, IOExceptionWithFile {
		results = new Analyser().analyse(PROJECT_ROOT);
	}

	@Test
	public void testSaveSummary(){
		try {
			JSONConverter.saveSummary(results, output_path);
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
			JSONConverter.saveSummary(results, output_path);
		} catch (IOException ioe) {
			fail("IOException wasn't expected.");
		} catch (NullPointerException ne) {
			fail("NullPointerException wasn't expected.");
		}
		Project metricResults = JSONConverter.loadSummary(output_path);
		assertTrue(metricResults.equals(results));
	}
}
