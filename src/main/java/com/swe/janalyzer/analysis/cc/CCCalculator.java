package com.swe.janalyzer.analysis.cc;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.swe.janalyzer.analysis.MetricCalculator;
import com.swe.janalyzer.analysis.util.Util;
import com.swe.janalyzer.data.metriken.MetricResult;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static com.swe.janalyzer.util.Constants.*;

public class CCCalculator extends VoidVisitorAdapter<Void> implements MetricCalculator {

    private Map<String, String> cc_result;
    private Map<String, Integer> wmc_result;
    private int max_cc;


    public CCCalculator() {
        this(0);
    }
    public CCCalculator(int fileCount) {
        //TODO 8 == Number of average funcs / class. Give config option or measure
        cc_result = new HashMap<>(fileCount * 8);
        wmc_result = new HashMap<>(fileCount);
    }

    @Override
    public void calcResultsFor(Path path, String code, CompilationUnit cu) {
        this.visit(cu, null);
    }

    @Override
    public List<MetricResult> getCalculatedMetrics() {
        return Arrays.asList(
                new MetricResult(CC, false, true),
                new MetricResult(CC_MAX, true, true),
                new MetricResult(WMC, false, true),
                new MetricResult(WMC_MAX, true, true)
        );
    }

    @Override
    public List<MetricResult> getResults() {
        ArrayList<MetricResult> l = new ArrayList<>(1);
        l.add(new MetricResult(CC, cc_result ));
        l.add(Util.metricOfBasicValue(CC_MAX, GENERAL_KEY, max_cc, true));

        //WMC Metric
        Map<String, String> wmc_result_asString = wmc_result.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> String.valueOf(e.getValue())
        ));
        l.add(new MetricResult(WMC, wmc_result_asString ));

        int wmc_max = wmc_result.values().stream().max(Integer::compareTo).orElse(0);
        l.add(Util.metricOfBasicValue(WMC_MAX, GENERAL_KEY, wmc_max, true));

        return l;
    }


    @Override
    public void clear() {
        cc_result.clear();
        this.wmc_result.clear();
        this.max_cc =0;
    }

    public void initBeforeNewProject(int fileCount){
        cc_result = new HashMap<>(fileCount);
        wmc_result = new HashMap<>(fileCount);
    }


    private void handleDecl(Node decl){
        Optional<Node> parentNode = decl.getParentNode();
        if(!parentNode.isPresent()){
            //This MethodDeclaration has no parent- This should never happen
            return;
        }
        Node parent = parentNode.get();

        if(parent.getClass() != ClassOrInterfaceDeclaration.class){
            //If this function is not a sippling of a class
            return;
        }
        ClassOrInterfaceDeclaration parentClass =
                (ClassOrInterfaceDeclaration) parentNode.get();

        if(parentClass.isInterface()){
            return;
        }

        final int totalCCValue = 1 + decl.stream()
                .filter(node -> !inAnonymusFunc(node, decl))
                .mapToInt(this::toCCValue)
                .sum();

        max_cc = Integer.max(max_cc, totalCCValue);

        cc_result.put(parentClass.getNameAsString() + "::" + nameOf(decl),
                    Integer.toString(totalCCValue));
        addCCToWMC(parentClass.getNameAsString(), totalCCValue);
    }

    private void addCCToWMC(String className, int ccValue) {
        wmc_result.merge(className, ccValue, Integer::sum);
    }

    private String nameOf(Node decl) {
        if(decl.getClass() == MethodDeclaration.class){
            MethodDeclaration decl1 = (MethodDeclaration) decl;
            String fullDecl = decl1.getDeclarationAsString(false, false, true);
            int endOfReturnType = fullDecl.indexOf(" ");
            return fullDecl.substring(endOfReturnType +1);
        }else if(decl.getClass() == ConstructorDeclaration.class){
            ConstructorDeclaration decl1 = (ConstructorDeclaration) decl;
            return decl1.getDeclarationAsString(false, false , true);
        }
        throw new IllegalArgumentException("Node was of an unsupported type");
    }

    /*
    This Method checks upwards the tree stopping at upper_bound latest, whether node is
    in an anonymous class

    TODO Atm every node in the AST is visited. If no anonymousExpr are visited downwards
    no checks upwards are needed

     */
    private boolean inAnonymusFunc(Node node, Node upper_bound) {
        Optional<Node> parentNode = node.getParentNode();
        if(!parentNode.isPresent()){
            return false;
        }
        Node parent = parentNode.get();
        //If upper bound reached
        if(parent.equals(upper_bound)){
            return false;
        }

        Class parentClazz = parent.getClass();
        if(parentClazz != ObjectCreationExpr.class){
            //Maybe the grandparent is an anonymous class expression
            return inAnonymusFunc(parent, upper_bound);
        }

        ObjectCreationExpr anonymousClassExpr = (ObjectCreationExpr) parent;
        if(anonymousClassExpr.getAnonymousClassBody().isPresent()){
            return true;
        }else{
            return inAnonymusFunc(parent,upper_bound);
        }
    }
    @Override
    public void visit(ConstructorDeclaration decl, Void arg){
        super.visit(decl, arg);
        handleDecl(decl);

    }
    @Override
    public void visit(MethodDeclaration decl, Void arg){
        //TODO Test this code
        super.visit(decl, arg);
        handleDecl(decl);
    }

    private int toCCValue(Node node){
        Class clazz = node.getClass();
        if((clazz == DoStmt.class)
                || (clazz == ExplicitConstructorInvocationStmt.class)
                || (clazz == ObjectCreationExpr.class)
                || (clazz == ForEachStmt.class)
                || (clazz == ForStmt.class)
                || (clazz == IfStmt.class)
                || (clazz == WhileStmt.class)
                || (clazz == MethodCallExpr.class)
                || (clazz == CatchClause.class)
        ){
            return 1;
        } else if (clazz == SwitchStmt.class) {
            SwitchStmt switchStmt = (SwitchStmt) node;
            return switchStmt.getEntries().size();
        } else {
            return 0;
        }
    }
}
