package com.swe.janalyzer.analysis.loc;

import com.github.javaparser.ast.CompilationUnit;
import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.util.Util;
import com.swe.janalyzer.data.metriken.MetricResult;

import java.nio.file.Path;
import java.util.*;

import static com.swe.janalyzer.util.Constants.*;

public class LOCCalculator implements MetricCalculator {

  private Map<String, String> result;
    private int locCumulated = 0;
    private Path projectRoot;

  @Override
  public void calcResultsFor(Path path, String code, CompilationUnit cu) {
      int locValue = countLOCfile(code);
      locCumulated += locValue;

      String relativePath;
      if(projectRoot != null){
        relativePath = projectRoot.relativize(path).toString();
      }else{
        relativePath = path.toString();
      }

      result.put(
              relativePath,
              Integer.toString(locValue)
      );
  }

  @Override
  public List<MetricResult> getResults() {
      List<MetricResult> l = new ArrayList<>(1);
      l.add(new MetricResult(LOC, result ));

      l.add(Util.metricOfBasicValue(LOC_CUM, GENERAL_KEY, locCumulated, true));
      return l;
  }

  @Override
  public void clear() {
    result.clear();
  }


  private int fileCounter;
  private boolean commentOverRows;



  public LOCCalculator(){
    this(16, null);
  }

  public LOCCalculator(int fileCount, Path projectRoot){
    this.fileCounter=0;
    this.commentOverRows=false;
    result = new HashMap<>(fileCount);
    this.projectRoot = projectRoot;
  }

  public int get_fileCounter() {

    return this.fileCounter;
  }

  public void set_fileCounter(int fileCounter) {

    this.fileCounter=fileCounter;
  }

  public boolean get_commentOverRows() {

    return this.commentOverRows;
  }

  public void set_commentOverRows(boolean commentOverRows) {

    this.commentOverRows=commentOverRows;
  }



  /**
   *
   * if a new multiple line comment begins, the function returns true
   * otherwise it returns false
   *
   */

  public boolean beginComment(String line) {

    while(!line.isEmpty()) {
      int index=line.indexOf("/*");
      int indexSC=line.indexOf("//");
      if(index==-1&&indexSC==-1) {
        return false;

      }
      else if((indexSC!=-1 &&indexSC<index||index==-1)) {
        return false;
      }
      else if(index!=-1 &&index<indexSC||indexSC==-1) {
        index=line.indexOf("*/");
        if(index==-1) {
          return true;
        }
        else if(index+2==line.length()) {
          return false;
        }
      }
    }
    return false;
  }


  public String cutOutStrings(String line) {

    boolean activeString=false;
    boolean comment=this.commentOverRows;
    String cleanLine="";



    for(int pos=0;pos<line.length();pos++) {

      if(pos+1<line.length()&& line.charAt(pos)=='/' && line.charAt(pos+1)=='*' && !activeString) {
        comment=true;
      }

      if(pos+1<line.length()&& line.charAt(pos)=='*' && line.charAt(pos+1)=='/' && !activeString) {
        comment=false;
      }

      if((pos==0 && line.charAt(0)=='\"' ||pos>0 &&line.charAt(pos)=='\"' && line.charAt(pos-1)!='\\' )&& !comment) {

        cleanLine+=line.charAt(pos);
        activeString=!activeString;
      }
      if(!activeString) {
        cleanLine+=line.charAt(pos);
      }
    }
    return cleanLine;

  }


  /**
   *
   * if the line is only a comment, it returns true
   * otherwise it returns false
   *
   * the function also finds out if multiple comment starts or ends
   *
   */


  public void onlyComment(String line) {



    boolean code=false;
    int index=0;
    int indexSC=0;

    if(line.isEmpty()) {
      return;
    }

    else if(line.equals("*/")) {
      this.commentOverRows=false;
      return;
    }

    while(!line.isEmpty()) {

      index=line.indexOf("*/");
      if(index==-1) {
        this.commentOverRows=true;
        break;
      }
      else {
        line=line.substring(index+2);
        line.trim();
        index=line.indexOf("/*");
        indexSC=line.indexOf("//");
        if(index==-1&&indexSC==-1) {
          if(!line.isEmpty()) {
            code=true;
          }
          this.commentOverRows=false;
          break;
        }
        else if(indexSC!=-1 &&indexSC<index||index==-1){
          this.commentOverRows=false;
          if(indexSC!=0) {
            code=true;
          }
          break;

        }
        else if(index!=-1 &&index<indexSC||indexSC==-1) {
          if(index!=0) {
            code=true;
            line=line.substring(index);
          }
          this.commentOverRows=true;
        }


      }


    }

    if(code) {
      this.fileCounter++;
    }


  }


  /**
   *
   *
   * counts lines of code
   *
   *
   */

  public int countLOCfile(String currentFile){

    this.fileCounter=0;
    this.commentOverRows=false;

    Scanner scanner = new Scanner(currentFile);
     String line="";

      while(scanner.hasNextLine()){
        line=scanner.nextLine();

        line=line.trim();
        line=this.cutOutStrings(line);

        if(line.isEmpty()||line.startsWith("//")) {
          continue;
        }

        else if(line.startsWith("/*")||this.commentOverRows) {

          this.onlyComment(line);

        }
        else {
          this.fileCounter++;
          this.commentOverRows=this.beginComment(line);
        }

      }

    return this.fileCounter;
  }

}
