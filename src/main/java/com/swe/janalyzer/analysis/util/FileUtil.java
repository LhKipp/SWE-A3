package com.swe.janalyzer.analysis.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileUtil {

    /**
     * Returns all files matching predicate which are in rootFolder or a subdirectory of rootFolder.
     * @param rootFolder
     * @param predicate
     * @return List containing all paths matching predicate which are in rootFolder or a subdirectory
     * @throws IOException
     */
    public static List<Path> listAllFilesRecursivly(Path rootFolder, Predicate<Path> predicate) throws IOException {
        final List<Path> files = new ArrayList<>();
        Files.walkFileTree(rootFolder, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (predicate.test(file)) {
                    files.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return files;
    }
}
