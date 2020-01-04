package com.swe.janalyzer.gui.data;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NamedPath {

    private Path path;
    private String customName;

    public NamedPath(){
        this(null, "");
    }
    public NamedPath(Path path, String customName) {
        this.path = path;
        this.customName = customName;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public void set(NamedPath other) {
        this.customName = other.customName;
        this.path = other.path;
    }
}
