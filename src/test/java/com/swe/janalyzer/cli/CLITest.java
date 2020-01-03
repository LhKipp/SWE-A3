package com.swe.janalyzer.cli;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CLITest {

    private CLI c = new CLI();

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup(){
      System.setOut(new PrintStream(outContent));
    }

    @Test
    public void help1() {
//        String[] args = {"--help"};
//        c.handle(args);
        //assert spam on terminal
    }

    @Test
    public void help2() {
//        String[] args = {"--manual"};
//        c.handle(args);
        //assert spam on terminal
    }

    @Test
    public void verbose() {
        String[] args = {"-v","Testdateien/Graphs"};
        c.handle(args);
        String expected = "Processing file ​Testdateien/Graphs/FloydWarshall.java\n"+
        "Processing file ​Testdateien/Graphs/MatrixGraphs.java\n"+
        "Processing file ​Testdateien/Graphs/PrimMST.java\n"+
        "Processing file ​Testdateien/Graphs/BellmanFord.java\n"+
        "Processing file ​Testdateien/Graphs/Cycles.java\n"+
        "Processing file ​Testdateien/Graphs/Graphs.java\n"+
        "Processing file ​Testdateien/Graphs/ConnectedComponent.java\n"+
        "All files analyzed\n"+
                "Writing results to ​/home/leonhard/java_analyzer/Graphs_0";
//        assertEquals(expected, outContent.toString());
    }

    @Test
    public void output() {
        String[] args = {"-v","Testdateien/Graphs", "--output", "hi"};
        System.out.println(outContent);
        assertEquals(0, c.handle(args));
    }

    @Test
    public void shortOptChain(){
        String[] args = {"-vo","hi2", "Testdateien/Graphs"};
//        System.out.println(outContent);
        assertEquals(0, c.handle(args));
    }

    @Test
    public void humanOpt(){
        String[] args = {"-h", "Testdateien/Graphs"};
        c.handle(args);
        System.out.println(outContent);
    }
}