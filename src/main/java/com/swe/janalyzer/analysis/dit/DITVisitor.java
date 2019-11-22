package com.swe.janalyzer.analysis.dit;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.swe.janalyzer.util.ClassSpecifier;

import java.util.Map;

class DITVisitor extends VoidVisitorAdapter<Void> {

    private Map<ClassSpecifier,ClassSpecifier> inheritanceTable;

    public DITVisitor(Map<ClassSpecifier, ClassSpecifier> inheritanceTable) {
        this.inheritanceTable = inheritanceTable;
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


