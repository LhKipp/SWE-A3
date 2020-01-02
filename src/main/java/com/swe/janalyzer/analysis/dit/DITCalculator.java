package com.swe.janalyzer.analysis.dit;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.util.Util;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.MetricResult;
import com.swe.janalyzer.util.ClassSpecifier;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.swe.janalyzer.util.Constants.*;

public class DITCalculator extends VoidVisitorAdapter<Void> implements MetricCalculator {

    private Map<ClassSpecifier,ClassSpecifier> inheritanceTable;

    @Override
    public void calcResultsFor(Path path, String code, CompilationUnit cu) {
        super.visit(cu, null);
    }

    @Override
    public List<MetricResult> getResults() {
        Map<ClassSpecifier, ClassMetrics> oldDataFormat = new HashMap<>(10);
        this.injectResultsIn(oldDataFormat);
        ArrayList<MetricResult> l = new ArrayList<>(1);
        l.add(new MetricResult(
                DIT,
                //Old Data Format to new one
                oldDataFormat.entrySet().stream()
                .collect(Collectors.toMap(
                       e -> e.getKey().getAsString() ,
                        e -> Integer.toString(e.getValue().getDit())))
        ));

        //MAX DIT Metric
        int dit_max = oldDataFormat.values().stream()
                .mapToInt(ClassMetrics::getDit)
                .max()
                .orElse(0);
        l.add(Util.metricOfBasicValue(DIT_MAX, GENERAL_KEY,dit_max ));
        return l;
    }

    @Override
    public void clear() {
        inheritanceTable.clear();
    }

    public DITCalculator() {
        this(10);
    }

    public DITCalculator(int classCount) {
        inheritanceTable = new HashMap<>(classCount);
    }

    /**
     * This methods populates the Map <Code>classMetrics</Code> with the found dit values
     *
     * This methods resolves the inheritanceTable by first filtering out all classes not inheriting.
     * Then it filters out all classes inheriting from library classes.
     * Then it iterates over the inheritance table, removing Classes which are in classMetrics,
     * until the inheritanceTable is empty
     *
     * If the Code doesn't compile and has cyclic Dependencies, this code may loop forever.
     *
     */
    public void injectResultsIn(Map<ClassSpecifier, ClassMetrics> classMetrics){
        //This line has to be first, because of the predicate.
        //<Code>inheritsFromLibraryClass</Code> assumes all projekt classes are in inheritanceTable!
        filterOutInto(classMetrics,
                this::inheritsFromLibraryClass,
                1);
        filterOutInto(classMetrics,
                    this::doesNotExtend,
                    0);


        //Partition inheritanceTable
        Map<Boolean, List<Map.Entry<ClassSpecifier, ClassSpecifier>>> partitionedTable
                = inheritanceTable.entrySet().stream()
                .collect(Collectors.partitioningBy(
                        entry -> classMetrics.containsKey(entry.getValue())
                ));

        List<Map.Entry<ClassSpecifier, ClassSpecifier>> entriesInheritingKnownClass
                = partitionedTable.get(true);
        //while partitioned table is not empty, take good ones insert them into classMetrics
        //and repartition bad ones
        while(!entriesInheritingKnownClass.isEmpty()){
            entriesInheritingKnownClass
                    .forEach(e ->{
                        putWithForce(classMetrics,
                                e,
                    classMetrics.get(e.getValue()).getDit() + 1
                            );
                    });

            //Partition false items again
            partitionedTable =
                partitionedTable.get(false).stream()
                    .collect(Collectors.partitioningBy(
                            entry -> classMetrics.containsKey(entry.getKey())
                    ));
            entriesInheritingKnownClass =
                    partitionedTable.get(true);
        }
    }

    private void filterOutInto(
            Map<ClassSpecifier, ClassMetrics> into,
            Predicate<Map.Entry> filter,
            int updateDitTo) {

        //TODO Performance Improvement. Remove the toRemove, make a cache array
        List<Map.Entry<ClassSpecifier, ClassSpecifier>> toRemove= new ArrayList<>(inheritanceTable.size());

        Iterator<Map.Entry<ClassSpecifier, ClassSpecifier>> iterator = inheritanceTable.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<ClassSpecifier, ClassSpecifier> entry = iterator.next();
            if(filter.test(entry)) {
                putWithForce(into, entry, updateDitTo);
                toRemove.add(entry);
            }
        }
        toRemove.forEach(e ->{
            inheritanceTable.remove(e.getKey());
        });
    }
    private void putWithForce(
            Map<ClassSpecifier, ClassMetrics> into,
            Map.Entry<ClassSpecifier, ClassSpecifier> entry,
            int newDitValue){

            ClassMetrics metric = into.putIfAbsent(
                    entry.getKey(),
                    new ClassMetrics(newDitValue)
            );
            //Else if metric has been present
            if(metric != null) {
                metric.setDit(newDitValue);
            }
    }

    private boolean doesNotExtend(Map.Entry<ClassSpecifier, ClassSpecifier> entry) {
        return entry.getValue() == null;
    }

    private boolean inheritsFromLibraryClass(Map.Entry<ClassSpecifier, ClassSpecifier> entry) {
        return entry.getValue() != null && !inheritanceTable.containsKey(entry.getValue());
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration decl, Void arg){
        super.visit(decl, arg);

        if(decl.isInterface()){
            return;
        }
        NodeList<ClassOrInterfaceType> extendedTypes = decl.getExtendedTypes();

        if(extendedTypes.isEmpty()){
            inheritanceTable.put(
                    new ClassSpecifier(decl.getNameAsString()),
                    null
            );
        }else{
            for(ClassOrInterfaceType type : extendedTypes){
                inheritanceTable.put(
                        new ClassSpecifier(decl.getNameAsString()),
                        new ClassSpecifier(type.getNameAsString())
                );
            }
        }
    }

}
