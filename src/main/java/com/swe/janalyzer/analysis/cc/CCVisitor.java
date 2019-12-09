package com.swe.janalyzer.analysis.cc;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.util.ClassSpecifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CCVisitor extends VoidVisitorAdapter<Void> {


    private Map<ClassSpecifier, ClassMetrics> classMetrics;

    public CCVisitor(Map<ClassSpecifier, ClassMetrics> classMetrics) {
        this.classMetrics = classMetrics;
    }

    @Override
    public void visit(MethodDeclaration decl, Void arg){
        //TODO Test this code
        super.visit(decl, arg);

        ClassOrInterfaceDeclaration parentClass =
                (ClassOrInterfaceDeclaration)decl.getParentNode().get();
        
        if(parentClass.isInterface()){
            return;
        }

        final int totalCCValue = 1 + decl.stream()
                .filter(node -> !inAnonymusFunc(node, decl))
                .mapToInt(this::toCCValue)
                .sum();

        ClassSpecifier classSpecifier = new ClassSpecifier(parentClass.getNameAsString());
        FunctionCC funcCC = new FunctionCC(
                decl.getNameAsString(),
                totalCCValue
        );

        if(!classMetrics.containsKey(classSpecifier)){
           //Compute count of methods in class, so that array is allocated correctly
            final int methodCount = parentClass.getMethods().size();
            final List<FunctionCC> functionCCs = new ArrayList<>(methodCount);
            classMetrics.put(
                    classSpecifier,
                    new ClassMetrics(functionCCs)
            );
        }else{//if class is already found just add this method
            classMetrics.get(classSpecifier).getFunctionCCs().add(funcCC);
        }
    }

    /*
    This Method checks upwards the tree stopping at decl latest, whether node is
    in an anonymous class

    TODO Atm every node in the AST is visited. If no anonymousExpr are visited downwards
    no checks upwards are needed

     */
    private boolean inAnonymusFunc(Node node, MethodDeclaration decl) {
        Optional<Node> parentNode = node.getParentNode();
        if(!parentNode.isPresent()){
            return false;
        }
        Node parent = parentNode.get();
        //If upper bound reached
        if(parent.equals(decl)){
            return false;
        }

        Class parentClazz = parent.getClass();
        if(parentClazz != ObjectCreationExpr.class){
            //Maybe the grandparent is an anonymous class expression
            return inAnonymusFunc(parent, decl);
        }

        ObjectCreationExpr anonymousClassExpr = (ObjectCreationExpr) parent;
        if(anonymousClassExpr.getAnonymousClassBody().isPresent()){
            return true;
        }else{
            return inAnonymusFunc(parent,decl);
        }

    }

    private int toCCValue(Node node){
        Class clazz = node.getClass();
        if(clazz == DoStmt.class
                ||clazz == ExplicitConstructorInvocationStmt.class
                || clazz == ObjectCreationExpr.class
                || clazz == ForEachStmt.class
                || clazz == ForStmt.class
                || clazz == IfStmt.class
                || clazz == WhileStmt.class
                || clazz == TryStmt.class
                || clazz == MethodCallExpr.class
                || clazz == CatchClause.class
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
