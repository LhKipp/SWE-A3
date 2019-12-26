package com.swe.janalyzer;

import java.io.IOException;

import com.swe.janalyzer.cli.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( int argc, String[] args ) throws NullPointerException, IOException
    {
        if(args.length > 0){
            System.out.println("Handle Args cli");
            CLI abfrageCli = new CLI();
            abfrageCli.cli(args);
        }else{
            System.out.println("Gui starten");
        }
    }
}
