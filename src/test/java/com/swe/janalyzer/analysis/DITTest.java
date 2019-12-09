package com.swe.janalyzer.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.swe.janalyzer.analysis.dit.DITCalculator;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.util.ClassSpecifier;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class DITTest
{
    private static Summary result;

    @BeforeClass
    public static void setupClass() throws IOException {
        MetricCalculator calc = new MetricCalculatorImpl();
        Summary result = calc.calculate(Paths.get("./src/test/java/com/swe/janalyzer/resources/ditTest"));

        Map<ClassSpecifier, ClassMetrics> classMetrics = result.getClassMetrics();
        Map<String, Integer> actual = new HashMap<>();
        actual.put("Grandparent", 0);
        actual.put("Child", 2);
        actual.put("ChildB", 2);
        actual.put("Parent", 1);
        actual.put("ParentB", 1);

        classMetrics.forEach((k, v) ->{
            assertEquals((int)actual.get(k.getAsString()),v.getDit());
        });
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
