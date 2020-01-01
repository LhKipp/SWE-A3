package com.swe.janalyzer;

import com.swe.janalyzer.cli.CLI;


/**
 * Hello world!
 *
 */
public class App 
{
    public static int main(String[] args )
    {
        if(args.length > 0){
            CLI cli = new CLI();
            return cli.handle(args);
        }else{
            System.out.println("Gui starten");
            return 0;
        }
    }
}
