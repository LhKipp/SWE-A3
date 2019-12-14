package com.swe.janalyzer.analysis;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.util.ClassSpecifier;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class CCTest {

    public static Summary result;
    public static List<FunctionCC> CCTest;

    @BeforeClass
    public static void setup() throws IOException {
        MetricCalculator calc  = new MetricCalculatorImpl();
        result = calc.calculate(Paths.get("./src/test/java/com/swe/janalyzer/resources/ccTest"));
        CCTest = result.getClassMetrics().get(new ClassSpecifier("CCObject")).getFunctionCCs();
    }

    @Test
    public void objCreation() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("objCreation"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void arrayCreation() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("arrayCreation"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 1);
    }

    @Test
    public void empty() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("empty"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 1);
    }

    @Test
    public void ifMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("ifMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void ifElseMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("ifElseMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void forMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("forMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void whileMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("whileMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void doWhileMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("doWhileMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 2);
    }

    @Test
    public void tryMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("tryMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(cc.getCCValue(), 1);
    }

    @Test
    public void tryCatchMethod() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("tryCatchMethod"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(2, cc.getCCValue());
    }
    @Test
    public void everything() throws Exception {
        FunctionCC cc = CCTest.stream()
                .filter(f -> f.getFuncName().equals("everything"))
                .findAny().orElseThrow(() ->new Exception("Method not found"));
        assertEquals(9, cc.getCCValue());
    }
}