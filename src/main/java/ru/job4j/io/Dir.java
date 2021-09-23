package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class Dir {

    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (isExistingDirectory(file)) {
            System.out.printf("%s : %s%n", file.getName(), file.length());
            for (File subfile : Objects.requireNonNull(file.listFiles())) {
                System.out.printf("%s : %s%n", subfile.getName(), subfile.length());
            }
        }
    }

    private static boolean isExistingDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        return true;
    }
}