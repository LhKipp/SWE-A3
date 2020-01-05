package com.swe.janalyzer.util;

import com.swe.janalyzer.data.metriken.MetricResult;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    public static boolean validateFolder(final String folder){
        return Files.isDirectory(Paths.get(folder));
    }
    public static boolean validateFolder(final Path folder){
        return Files.isDirectory(folder);
    }

    /**
     * Returns the running index analyzation number of the given project.
     * This method does so by checking how often the same project has been analyzed before in the dir "outputDir".
     * @return
     */
    public static int analyzationNumber(final Path projectRoot, final Path outputDir) throws IOException {
        if(!Files.exists(outputDir)){
            return 0;
        }
        String projectName = projectRoot.getFileName().toString();

        int similarProjects = 0;
        for (Path path : Files.newDirectoryStream(outputDir,
                p -> p.getFileName().toString().startsWith(projectName + "_"))) {
            similarProjects++;
        }
        return similarProjects;
    }

    public static List<Path> listAllFilesInFolder(Path folder) throws IOException {
        try (Stream<Path> walk = Files.walk(folder)) {

            return walk.filter(Files::isRegularFile)
                    .filter(p -> !Files.isDirectory(p))
                    .collect(Collectors.toList());
        }

    }
}
