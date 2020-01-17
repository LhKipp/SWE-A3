package com.swe.janalyzer.util;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class KeyConverter {
    public static final int totalLength = 30;
    public static final int minBufferLen = 5;
    public static final int doublePointBufferLen = 2;
    public static final int backslashBufferLen = 1;
    public static final int threeDotsBufferLen = 3;

    public static String convertName(String name) {
        if(name.length() > totalLength) {
            return "..." + name.substring(name.length() - (totalLength - threeDotsBufferLen));
        }
        return name;
    }

    public static String convertPath(Path pathName) {
        if (pathName.toString().length() > totalLength) {
            String name = pathName.getFileName().toString();

            if (name.length() > totalLength) {
                name = "..." + name.substring(name.length() - (totalLength - threeDotsBufferLen));
            } else {
                while (pathName != null) {
                    pathName = pathName.getParent();

                    int buffer = totalLength - name.length() - threeDotsBufferLen - backslashBufferLen;
                    if (buffer <= 0) break;

                    String dir = pathName.getFileName().toString();

                    if (buffer >= minBufferLen) {
                        int dirLen = dir.length();
                        if (dirLen > buffer) {
                            name = "..." + dir.substring(dir.length() - buffer) + "\\" + name;
                        } else {
                            name = dir + "\\" + name;
                        }
                    } else break;
                }
            }
            return name;
        } else {
            return pathName.toString();
        }
    }

    public static String convertClass(String className) {
        String[] packageSections = className.toString().split("::");

        String name = "";
        String tmp = packageSections[1];
        if (tmp.length() > totalLength) {
            name = "..." + tmp.substring(tmp.length() - (totalLength - threeDotsBufferLen));
        } else {
            int buffer = (totalLength - tmp.length() - doublePointBufferLen - threeDotsBufferLen);
            if (buffer >= minBufferLen) {
                if(packageSections[0].length() - buffer > 0) {
                    name = "..." + packageSections[0].substring(packageSections[0].length() - buffer) + "::" + tmp;
                }else{
                    name = packageSections[0] + "::" + tmp;
                }
            } else {
                name = packageSections[1];
            }
        }
        return name;
    }
}
