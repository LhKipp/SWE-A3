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


### Verbesserung der der DetaiView:
Sofern ein zu langer Bezeichner für eine Klasse, Methode etc. gesondert behandelt werden soll (Standard ist, dass jeder Bezeichner, der Länger als ein angegebener Wert ist, VORNE abgescnitten wird), ist dies wie folgt zu tun:
1. Die Methode zur gesonderten Behandlung muss in der Klasse **KeyConverter.java** implementiert werden.
2. In der Klasse **DetailChart.java** muss ein weiterer Case-Zweig in der Methode *tableFor()* hinzugefügt werden, in dem die zuvor implementiert Methode aufgerufen wird. 