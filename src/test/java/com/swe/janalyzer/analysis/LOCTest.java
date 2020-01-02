package com.swe.janalyzer.analysis;

import com.swe.janalyzer.analysis.loc.LOCCalculator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;


public class LOCTest {
//
//  LOCCalculator counter;
//  Path f;
//
//  @Before
//  public void setUp() {
//
//    counter=new LOCCalculator();
//
//  }
//
//
//  @Test
//  public void noComments() {
//
//
//     f= Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/keinKommentar.txt");
//     assertEquals(counter.countLOCfile(f),12);
//
//
//
//  }
//
//
//  @Test
//  public void stringComment() {
//
//
//     f= Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/stringComment.txt");
//     assertEquals(counter.countLOCfile(f),10);
//
//
//
//  }
//  @Test
//  public void singleLineComment() {
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/singleLineComment1.txt");
//    assertEquals(counter.countLOCfile(f),0);
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/singleLineComment2.txt");
//    assertEquals(counter.countLOCfile(f),5);
//
//  }
//  @Test
//  public void multiLineComment() {
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/multiLineComment1.txt");
//    assertEquals(counter.countLOCfile(f),0);
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/multiLineComment2.txt");
//    assertEquals(counter.countLOCfile(f),2);
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/multiLineComment3.txt");
//    assertEquals(counter.countLOCfile(f),3);
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/multiLineComment4.txt");
//    assertEquals(counter.countLOCfile(f),3);
//
//
//  }
//
//  @Test
//  public void mixedComment() {
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/mixedComment1.txt");
//    assertEquals(counter.countLOCfile(f),4);
//
//    f=Paths.get("./src/test/java/com/swe/janalyzer/resources/locTest/mixedComment2.txt");
//    assertEquals(counter.countLOCfile(f),8);
//
//
//  }
//
//  @Test
//  public void beginCommentTest() {
//
//    String noComment="Just an easy example";
//    assertFalse(counter.beginComment(noComment));
//
//    String noComment1="/Just an easy example*/";
//    assertFalse(counter.beginComment(noComment1));
//
//    String singleLineComment1="//";
//    assertFalse(counter.beginComment(singleLineComment1));
//
//    String singleLineComment2="code //";
//    assertFalse(counter.beginComment(singleLineComment2));
//
//    String singleLineComment3="code // comment  /*";
//    assertFalse(counter.beginComment(singleLineComment3));
//
//    String multipleLineComment1="/*";
//    assertTrue(counter.beginComment(multipleLineComment1));
//
//    String multipleLineComment2="a/* comment*/";
//    assertFalse(counter.beginComment(multipleLineComment2));
//
//  }
//
//  @Test
//  public void onlyCommentTest() {
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String multipleLineCommentEnds="*/";
//    counter.onlyComment(multipleLineCommentEnds);
//    assertEquals(counter.get_fileCounter(),0);
//    assertFalse(counter.get_commentOverRows());
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String multipleLineCommentEnds2="comment*/";
//    counter.onlyComment(multipleLineCommentEnds2);
//    assertEquals(counter.get_fileCounter(),0);
//    assertFalse(counter.get_commentOverRows());
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String multipleLineCommentEnds3="comment*/code";
//    counter.onlyComment(multipleLineCommentEnds3);
//    assertEquals(counter.get_fileCounter(),1);
//    assertFalse(counter.get_commentOverRows());
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String multipleLineCommentStarts1="*//*";
//    counter.onlyComment(multipleLineCommentStarts1);
//    assertEquals(counter.get_fileCounter(),0);
//    assertTrue(counter.get_commentOverRows());
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String multipleLineCommentStarts2="*/ code/*";
//    counter.onlyComment(multipleLineCommentStarts2);
//    assertEquals(counter.get_fileCounter(),1);
//    assertTrue(counter.get_commentOverRows());
//
//    counter.set_fileCounter(0);
//    counter.set_commentOverRows(true);
//    String singleCommentOperator="//*/";
//    counter.onlyComment(singleCommentOperator);
//    assertEquals(counter.get_fileCounter(),0);
//    assertFalse(counter.get_commentOverRows());
//  }
//
}




