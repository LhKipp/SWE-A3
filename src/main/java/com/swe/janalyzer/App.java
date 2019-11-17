package com.swe.janalyzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length > 0){
            System.out.println("Handle Args cli");
        }else{
            System.out.println("Gui starten");
        }
    }
}
