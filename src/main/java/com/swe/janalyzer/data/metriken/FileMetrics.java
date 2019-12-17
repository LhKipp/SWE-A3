package com.swe.janalyzer.data.metriken;

import java.nio.file.Path;

/**
 * Datenmodell für die Metriken eines Files.
 * {@link FileMetrics#file} ist der Pfad zum .java-File.
 * {@link FileMetrics#sloc} ist die Anzahl an Codezeilen im entsprechenden File.
 */
public class FileMetrics {
    private Path file;

    private int sloc;

    public FileMetrics(Path file) {
        this(file, Integer.MAX_VALUE);
    }
    public FileMetrics(Path file, int sloc) {
        this.file = file;
        this.sloc = sloc;
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
