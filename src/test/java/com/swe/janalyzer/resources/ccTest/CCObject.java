package com.swe.janalyzer.resources.ccTest;

public class CCObject {


    public int empty(){
        return 0;
    }

    public void ifMethod(){
        if(true){
            return;
        }
    }

    public void ifElseMethod(){
        if(true){
            return;
        }else{
            return;
        }
    }
    public int forMethod(){
        int b = 0;
        for (int i = 0; i < 5; i++) {
            b*=1;
        }
        return b;
    }
    public int whileMethod(){
        int b = 0;
        while(b < 5){
            b+=1;
        }
        return b;
    }
    public int doWhileMethod(){
        int b = 0;
        do{
            b+=1;
        }while(b < 5);
        return b;
    }
    //TODO ask client how to handle finally - for now this is 0
    public void tryMethod(){
        try{
            int i = 0;
        }finally {
            return;
        }
    }
    public void tryCatchMethod(){
        try{
            int i = 0;
        }catch (Exception e){

        }
        return;
    }

    public void everything(){//cc= 1

        if(true){//2
            return;
        }else{

        }
        CCObject a = new CCObject();//3
        this.equals(a);//4
        int i = 0;

        for (i = 0; i <10 ; i++) {//5
        }

        while (i < 1){//6

        }

        do{

        }while(i <1);//7

        try{

        } catch (ArithmeticException e){//8

        } catch(Exception e){//9

        }

    }
}
