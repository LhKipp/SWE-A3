package com.swe.janalyzer;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.ClassSpecifier;
import org.junit.Assert;
import org.junit.Before;
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
		private Summary summary;
		private Path correctPath;
		private Path incorrectPath;

		@Before
		public void init(){
				FileMetrics fm1 = new FileMetrics(Paths.get("./test1"));
				fm1.setSLOC(130);
				FileMetrics fm2 = new FileMetrics(Paths.get("./test2"));
				fm2.setSLOC(12);

				List<FileMetrics> fmList = new ArrayList<>();
				fmList.add(fm1);
				fmList.add(fm2);

				FunctionCC cc1 = new FunctionCC("met1", 13);
				FunctionCC cc2 = new FunctionCC("met2", 7);
				FunctionCC cc3 = new FunctionCC("met3", 29);
				FunctionCC cc4 = new FunctionCC("met4", 1);
				FunctionCC cc5 = new FunctionCC("met5", 5);

				List<FunctionCC> ccList1 = new ArrayList<>();
				ccList1.add(cc1);
				ccList1.add(cc2);
				ccList1.add(cc3);
				ccList1.add(cc4);

				List<FunctionCC> ccList2 = new ArrayList<>();
				ccList2.add(cc5);

				ClassMetrics cm1 = new ClassMetrics(9);
				cm1.setFunctionCCs(ccList1);

				ClassMetrics cm2 = new ClassMetrics(1);
				cm2.setFunctionCCs(ccList2);

				Map<ClassSpecifier, ClassMetrics> classMap = new HashMap<>();
				classMap.put(new ClassSpecifier("class1"), cm1);
				classMap.put(new ClassSpecifier("class2"), cm2);

				summary = new Summary();
				summary.setFileMetrics(fmList);
				summary.setClassMetrics(classMap);

				correctPath = Paths.get("./result.json");
				incorrectPath = Paths.get("./asd");
		}

		@Test
		public void testSave(){
				try {
						JSONConverter.save(summary, correctPath);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.save(summary, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}

				try {
						JSONConverter.save(null, correctPath);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}

				try {
						JSONConverter.save(null, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}
		}

		@Test
		public void testLoad() {
				try {
						JSONConverter.save(summary, correctPath);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						Summary sum1 = JSONConverter.load(correctPath);
						//assertEquals(summary, sum1);
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
				}
		}
}
