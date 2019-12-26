package com.swe.janalyzer.analysis.loc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.Map;

public class LOCCalculator {
  
  
  private int fileCounter;
  private boolean commentOverRows;
  
  
  
  public LOCCalculator(){
    this.fileCounter=0;
    this.commentOverRows=false;
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
 
  public int countLOCfile(Path currentFile) {
  
    FileReader fr;
    this.fileCounter=0;
    this.commentOverRows=false;
    
    try {
      fr = new FileReader(currentFile.toFile());
    
      BufferedReader br= new BufferedReader(fr);
      String line="";
    
      while((line=br.readLine()) != null) {
       
        line=line.trim(); 
        
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
      br.close();
    }
          
      
        
    catch (IOException e) {
      e.printStackTrace();
    }
    
    return this.fileCounter;
  }
  
}



