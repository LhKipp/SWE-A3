package com.swe.janalyzer.data.metriken.cc;


import java.util.ArrayList;
import java.util.List;

public class CC {
    private List<CCEntry> entries;

    public CC(int estimatedClassesCount) {
        this.entries = new ArrayList<>(estimatedClassesCount);
    }

    public List<CCEntry> entries() {
        return entries;
    }
}
