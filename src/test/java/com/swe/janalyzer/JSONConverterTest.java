package com.swe.janalyzer;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.ClassSpecifier;
import org.junit.Assert;
import org.junit.BeforeClass;
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

		@Test
		public void testSave(){
				Path path = Paths.get("result.json");
			System.out.println(path.toAbsolutePath().toString());
				Summary sum = new Summary();
				try {
						JSONConverter.save(sum, path);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.save(sum, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						System.err.println("filePath was null");
				}

				try {
						JSONConverter.save(null, path);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						System.err.println("summary was null");
				}

				try {
						JSONConverter.save(null, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						System.err.println("filePath and summary was null");
				}

				path = Paths.get("/nonexistingdir");
				try {
						JSONConverter.save(sum, path);
						fail("IOException was expected.");
				} catch (IOException ioe) {
						System.err.println("filePath wasn't defined");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}
		}

		@Test
		public void testLoad() throws IOException {
				FunctionCC method = new FunctionCC("method", 123);
				ArrayList<FunctionCC> list = new ArrayList<>(1);
				list.add(method);

				ClassMetrics cm = new ClassMetrics();
				cm.setFunctionCCs(list);
				cm.setDit(12);

				HashMap<ClassSpecifier,ClassMetrics> map = new HashMap<>(1);
				map.put(new ClassSpecifier("cl1"), cm);

				Path correctPath = Paths.get("result.json");
				Path wrongPath = Paths.get("filenotexist.xyz");
				Summary sum = new Summary();
				sum.setClassMetrics(map);
				try {
						JSONConverter.save(sum, correctPath);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}
				Summary loaded = JSONConverter.load(correctPath);

				try {
						assertEquals(sum, loaded);
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						assertNotEquals(sum, JSONConverter.load(correctPath));
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.load(null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						System.err.println("filePath not set.");
				}

				try {
						JSONConverter.load(wrongPath);
						fail("IOException was expected.");
				} catch (IOException ioe) {
						System.err.println("file didn't exist.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}
		}
}
