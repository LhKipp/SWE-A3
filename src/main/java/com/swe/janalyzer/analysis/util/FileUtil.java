package com.swe.janalyzer.analysis.util;

import com.swe.janalyzer.util.IOExceptionWithFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * Returns all java files which are in rootFolder or a subdirectory of rootFolder.
     * @param rootFolder
     * @return List containing all paths matching predicate which are in rootFolder or a subdirectory
     * @throws IOExceptionWithFile
     */
    public static List<Path> listAllJavaFiles(Path rootFolder) throws IOExceptionWithFile {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

        final List<Path> files = new ArrayList<>();
        final Path[] lastFile = {rootFolder};
        try {
            Files.walkFileTree(rootFolder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    lastFile[0] = file;
                    if (matcher.matches(file)) {
                        files.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new IOExceptionWithFile(e, lastFile[0]);
        }
        return files;
    }
}
