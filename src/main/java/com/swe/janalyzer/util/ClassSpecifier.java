package com.swe.janalyzer.util;

import java.util.Objects;

public class ClassSpecifier {
    private String className;

    public ClassSpecifier(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSpecifier that = (ClassSpecifier) o;
        return Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className);
    }

    @Override
    public String toString() {
        return this.className;
    }

    public String getAsString(){
        return this.className;
    }
}
