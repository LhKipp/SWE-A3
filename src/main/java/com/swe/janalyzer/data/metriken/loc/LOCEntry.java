package com.swe.janalyzer.data.metriken.loc;

import java.nio.file.Path;

public class LOCEntry {
    private Path filePath;
    private int loc_value;

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public int getLoc_value() {
        return loc_value;
    }

    public void setLoc_value(int loc_value) {
        this.loc_value = loc_value;
    }
}
