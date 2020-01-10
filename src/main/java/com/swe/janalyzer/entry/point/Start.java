package com.swe.janalyzer.entry.point;

import com.swe.janalyzer.cli.CLI;

public class Start {

    /**
     * Notwendig zum Erzeugen und Starten der .jar über mvn. (Grund: Die StartKlasse darf nicht die Application-Klasse von JavaFX nutzen).
     * Befehl zum Starten mittels Maven: mvn clean javafx:run
     */
    public static void main(String[] args) {
        if(args.length == 0){
            App.main(args);
        }else{
            new CLI().handle(args);
        }
    }
}
