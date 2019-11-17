package com.swe.janalyzer.data.metriken.loc;

import java.util.ArrayList;
import java.util.List;

public class LOC {
    private List<LOCEntry> entries;

    public LOC(){
        entries= new ArrayList<>();
    }

    public LOC(int estimatedProjectFileCount) {
        this.entries = new ArrayList<>(estimatedProjectFileCount);
    }

    public List<LOCEntry> entries() {
        return entries;
    }

}
