package com.swe.janalyzer;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.storage.JSONConverter;
import com.swe.janalyzer.util.ClassSpecifier;
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
		private Summary summary;
		private Options options;
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

				options = new Options();
				options.setCc(2);
				options.setDit(4);
				options.setCustomPath("hallo", incorrectPath);
				options.setLoc(200);
				options.setWmc(7);
		}

		@Test
		public void testSaveSummary(){
				try {
						JSONConverter.saveSummary(summary, correctPath);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.saveSummary(summary, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}

				try {
						JSONConverter.saveSummary(null, correctPath);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}

				try {
						JSONConverter.saveSummary(null, null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}
		}

		@Test
		public void testLoadSummary() throws IOException {
				try {
						JSONConverter.saveSummary(summary, correctPath);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}
				Summary loaded = JSONConverter.loadSummary(correctPath);

				try {
						Summary sum1 = JSONConverter.loadSummary(correctPath);
						assertEquals(summary, sum1);
						
						Summary sumWrong = new Summary();
						sumWrong.setClassMetrics(summary.getClassMetrics());
						assertNotEquals(sumWrong, sum1);
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
						fail("NullPointerException wasn't expected.");
				}

				try {
						JSONConverter.loadSummary(null);
						fail("NullPointerException was expected.");
				} catch (IOException ioe) {
						fail("IOException wasn't expected.");
				} catch (NullPointerException ne) {
				}
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
