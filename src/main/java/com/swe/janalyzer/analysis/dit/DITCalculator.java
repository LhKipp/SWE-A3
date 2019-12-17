package com.swe.janalyzer.analysis.dit;

import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.util.ClassSpecifier;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DITCalculator {
    private Map<ClassSpecifier, ClassSpecifier> inheritanceTable;

    public DITCalculator(int classCount){
        this(classCount, false);
    }

    public DITCalculator(int classCount, boolean multithreading) {
        if(multithreading){
            inheritanceTable = new ConcurrentHashMap<>(classCount);
        }else {
            inheritanceTable = new HashMap<>(classCount);
        }
    }

    public DITVisitor getASTVisitor(){
        return new DITVisitor(inheritanceTable);
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
                        entry -> classMetrics.containsKey(entry.getKey())
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
                    classMetrics.get(e.getKey()).getDit() + 1
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
}
