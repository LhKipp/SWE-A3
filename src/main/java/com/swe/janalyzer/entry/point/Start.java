package com.swe.janalyzer.entry.point;

public class Start {

    /**
     * Notwendig zum Erzeugen und Starten der .jar über mvn. (Grund: Die StartKlasse darf nicht die Application-Klasse von JavaFX nutzen).
     * Befehl zum Starten mittels Maven: mvn clean javafx:run
     */
    public static void main(String[] args) {
        App.main(args);
    }
}
