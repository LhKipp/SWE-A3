package com.swe.janalyzer.analysis;

import com.swe.janalyzer.SummaryMain;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.storage.JSONConverter;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestdateienTests {

    @Test
    public void graphProject() throws Exception {
        MetricCalculator calc = new MetricCalculatorImpl();
        Summary calculated = calc.calculate(Paths.get("./Testdateien/Graphs"));
        Summary expected = SummaryMain.getGraphSummary();


        Path calcPath = Paths.get("./src/test/java/com/swe/janalyzer/analysis/project_results/graph_calculated");
        Path expectedPath = Paths.get("./src/test/java/com/swe/janalyzer/analysis/project_results/graph_expected");
        Files.createDirectories(calcPath.getParent());
        Files.createDirectories(expectedPath.getParent());
        JSONConverter.save(calculated, calcPath);
        JSONConverter.save(expected, expectedPath); //Stackoverflow error
        assertEquals(expected, calculated);
        Util.equals(calculated, expected);
        assertTrue(Util.equals(calculated, expected));
    }

//    @Test
//    public void treeProject() throws Exception {
//        MetricCalculator calc = new MetricCalculatorImpl();
//        Summary calculated = calc.calculate(Paths.get("./Testdateien/Trees"));
//        Summary expected = SummaryMain.getTreeSummary();
//
//        assertEquals(expected, calculated);
//    }
//
//    @Test
//    public void preferencesProjekt() throws Exception {
//        MetricCalculator calc = new MetricCalculatorImpl();
//        Summary calculated = calc.calculate(Paths.get("./Testdateien/preferences"));
//        Summary expected = SummaryMain.getPreferencesSummary();
//
//        assertEquals(expected, calculated);
//    }

}