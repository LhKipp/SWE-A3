package com.swe.janalyzer.analysis;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.swe.janalyzer.analysis.cc.CCCalculator;
import com.swe.janalyzer.analysis.dit.DITCalculator;
import com.swe.janalyzer.analysis.loc.LOCCalculator;
import com.swe.janalyzer.analysis.util.FileUtil;
import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.data.metriken.Project;
import com.swe.janalyzer.util.IOExceptionWithFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Analyser {
    private LOCCalculator locCalculator = new LOCCalculator();
    private DITCalculator ditCalculator = new DITCalculator();
    private CCCalculator ccCalculator = new CCCalculator();

    private List<MetricCalculator> metricCalculators = Arrays.asList(
            locCalculator, ditCalculator, ccCalculator
    );

    public Analyser(){
    }

    /**
     * This method invokes every MetricCalculator added to metricCalculators list and returns their
     * results bundled into one list.
     * @param projectRoot - the root directory of the project
     * @return Every Metric calculated by the MetricCalculators
     * @throws IOException - If any file in the Project couldnt be opened
     * @throws ParseProblemException - If any file in the Project is ill formed
     */
    public Project analyse(Path projectRoot) throws ParseProblemException, IOExceptionWithFile {
        return analyse(projectRoot, false);
    }
    public Project analyse(Path projectRoot, boolean verbose) throws ParseProblemException, IOExceptionWithFile {
        metricCalculators.forEach(MetricCalculator::clear);

        List<Path> javaFiles = FileUtil.listAllJavaFiles(projectRoot);

        locCalculator.initBeforeNewProject(javaFiles.size(), projectRoot);
        ditCalculator.initBeforeNewProject(javaFiles.size());
        ccCalculator.initBeforeNewProject(javaFiles.size());

        for (Path p : javaFiles){
            if(verbose){
                System.out.println("Processing file ​" + p.toString());
            }

            String fileContent = null;
            try {
                fileContent = String.join("\n"
                        , Files.readAllLines(p, StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new IOExceptionWithFile(e, p);
            }

            CompilationUnit cu = StaticJavaParser.parse(fileContent);

            for (MetricCalculator calc : metricCalculators) {
                calc.calcResultsFor(p, fileContent, cu);
            }
        }

        List<MetricResult> results = new ArrayList<>((int) (metricCalculators.size() * 1.5));
        for (MetricCalculator calc : metricCalculators) {
            results.addAll(calc.getResults());
        }

        final String projectName = projectRoot.getFileName().toString();
        Project project = new Project(projectName, results);
        project.wasJustAnalysed();

        return project;
    }

    public List<MetricCalculator> getMetricCalculators() {
        return metricCalculators;
    }

    public void setMetricCalculators(List<MetricCalculator> metricCalculators) {
        this.metricCalculators = metricCalculators;
    }

    public List<MetricResult> getAnalysedMetrics(){
        return metricCalculators.stream()
                .map(MetricCalculator::getCalculatedMetrics)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
