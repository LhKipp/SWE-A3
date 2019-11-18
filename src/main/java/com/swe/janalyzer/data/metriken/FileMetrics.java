package com.swe.janalyzer.data.metriken;

import java.nio.file.Path;

public class FileMetrics {
    private Path file;

    private int sloc;

    public FileMetrics(Path file) {
        this.file = file;
    }

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }

    public int getSLOC() {
        return sloc;
    }

    public void setSLOC(int sloc) {
        this.sloc = sloc;
    }
}
