## Wie kann ich das Projekt compilieren?

Um das Projekt zu compilieren, muss folgende Software korrekt installiert sein:
1. Maven
2. JDK + JRE (Version 8+)

Im Terminal ist zu dem Projektordner zu navigieren und folgende Kommandos auszuführen.
```console
mvn package assembly:single
cp target/janalyzer-jar-with-dependencies.jar janalyzer.jar 
```
Danach liegt das Program als "janalyzer.jar" im Projektordner.


## Wie kann ich eine weitere Metrik hinzufügen?

Eine weitere Metrik kann hinzugefügt werden, indem 
1. Eine Klasse erstellt wird, die das Interface com.swe.janalyzer.analysis.MetricCalculator implementiert und die darin enthaltenen Methoden überschreibt.
2. Eine Instanz dieser Klasse dem Array "metricCalculators" aus der Klasse com.swe.janalyzer.analysis.Analyser hinzugefügt wird.
