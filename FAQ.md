## Wie kann ich eine weitere Metrik hinzufügen?

Eine weitere Metrik kann hinzugefügt werden, indem 
1. Eine Klasse erstellt wird, die das Interface com.swe.janalyzer.analysis.MetricCalculator implementiert und die darin enthaltenen Methoden überschreibt.
2. Eine Instanz dieser Klasse dem Array "metricCalculators" aus der Klasse com.swe.janalyzer.analysis.Analyser hinzugefügt wird.
