package com.swe.janalyzer.analysis.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileUtil {

    /**
     * Returns all java files which are in rootFolder or a subdirectory of rootFolder.
     * @param rootFolder
     * @return List containing all paths matching predicate which are in rootFolder or a subdirectory
     * @throws IOException
     */
    public static List<Path> listAllJavaFiles(Path rootFolder) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

        final List<Path> files = new ArrayList<>();
        Files.walkFileTree(rootFolder, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file)) {
                    files.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return files;
    }
}
