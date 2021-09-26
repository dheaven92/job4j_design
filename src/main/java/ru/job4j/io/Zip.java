package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean validateArgs(ArgsName args) {
        String source = args.get("d");
        String output = args.get("o");
        if (source == null || output == null) {
            throw new IllegalArgumentException("Arguments -d and -o are required");
        }
        if (!new File(source).isDirectory()) {
            throw new IllegalArgumentException("Argument -d must be a directory");
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Arguments -d and -o are required.");
        }
        ArgsName argNames = ArgsName.of(args);
        if (validateArgs(argNames)) {
            String extension = argNames.get("e");
            List<File> files = Search.search(
                    Path.of(argNames.get("d")),
                    f -> extension == null || !f.toFile().getName().endsWith(extension)
            ).stream()
                    .map(p -> new File(String.valueOf(p.toAbsolutePath())))
                    .collect(Collectors.toList());
            packFiles(files, new File(argNames.get("o")));
        }
    }
}
