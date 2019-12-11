package com.swe.janalyzer.analysis.cc;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
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

        ClassSpecifier classSpecifier = new ClassSpecifier(parentClass.getNameAsString());

        if(!classMetrics.containsKey(classSpecifier)){
            //Compute count of methods in class, so that array is allocated correctly
            final int methodCount = parentClass.getMethods().size();
            final List<FunctionCC> functionCCs = new ArrayList<>(methodCount);
            classMetrics.put(
                    classSpecifier,
                    new ClassMetrics(functionCCs)
            );
        }

        FunctionCC funcCC = new FunctionCC(
                nameOf(decl),
                totalCCValue
        );
        classMetrics.get(classSpecifier).getFunctionCCs().add(funcCC);
    }

    private String nameOf(Node decl) {
        if(decl.getClass() == MethodDeclaration.class){
            MethodDeclaration decl1 = (MethodDeclaration) decl;
            return decl1.getNameAsString();
        }else if(decl.getClass() == ConstructorDeclaration.class){
            ConstructorDeclaration decl1 = (ConstructorDeclaration) decl;
            return decl1.getNameAsString();
        }
        return "ERROR IN CC VISITOR";
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
        if(clazz == DoStmt.class
                || clazz == ExplicitConstructorInvocationStmt.class
                || clazz == ObjectCreationExpr.class
                || clazz == ForEachStmt.class
                || clazz == ForStmt.class
                || clazz == IfStmt.class
                || clazz == WhileStmt.class
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
