# SWE-A3
Project for the university course "software engineering"

## Adding new Metrics dynamically:

###1. step:
	go to com.swe.janalyzer.analysis and add a new package for your metriccalculator.

###2. step:
	create a class for your metriccalculator and let it implement the interface MetricCalculator.

###3. step:
	go to com.swe.janalyzer.analysis.Analyser.java and declare and intialize your metriccalculator as an attribute.

###4. step:
	put the generated object in the metricCalculators List. Now, your own metric will be considered during analysis.