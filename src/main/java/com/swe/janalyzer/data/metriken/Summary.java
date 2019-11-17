package com.swe.janalyzer.data.metriken;

import com.swe.janalyzer.data.metriken.cc.CC;
import com.swe.janalyzer.data.metriken.dit.DIT;
import com.swe.janalyzer.data.metriken.loc.LOC;

/**
 * Simple Struct holding all metrics
 */
public class Summary {
    private CC cc;
    private DIT dit;
    private LOC loc;

    //Shouldnt be necessary
    //private WMC wmcValue;
    //WMC if needed can be computed by CC


    public CC getCC() {
        return cc;
    }

    public void setCC(CC cc) {
        this.cc = cc;
    }

    public DIT getDIT() {
        return dit;
    }

    public void setDIT(DIT dit) {
        this.dit = dit;
    }

    public LOC getLOC() {
        return loc;
    }

    public void setLOC(LOC loc) {
        this.loc = loc;
    }
}
