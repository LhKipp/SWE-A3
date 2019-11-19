package com.swe.janalyzer.analysis.visitors;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class DITVisitor extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(ClassOrInterfaceDeclaration decl, Void arg){
        if(!decl.isInterface()){
            System.out.println(decl.getName());
        }
    }
}
