package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        if (validateArgs(argsName)) {
            try (Scanner in = new Scanner(new File(argsName.get("path")))) {
                String delimiter = argsName.get("delimiter");
                String filter = argsName.get("filter");
                List<Integer> skipIndexes = new ArrayList<>();
                String header = in.nextLine();
                String[] columns = header.split(delimiter);
                if (filter != null) {
                    for (int i = 0; i < columns.length; i++) {
                        if (!filter.contains(columns[i])) {
                            skipIndexes.add(i);
                        }
                    }
                }
                StringBuilder str = new StringBuilder();
                str.append(filterLine(header, delimiter, skipIndexes));
                while (in.hasNext()) {
                    str.append(filterLine(in.nextLine(), delimiter, skipIndexes));
                }
                writeToFile(str.toString(), argsName.get("out"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean validateArgs(ArgsName argsName) {
        String inPath = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String outPath = argsName.get("out");
        if (inPath == null || delimiter == null || outPath == null) {
            throw new IllegalArgumentException("Arguments -path -delimiter -out are required");
        }
        if (new File(inPath).isDirectory()) {
            throw new IllegalArgumentException("Argument -path must be a path to file, not a directory");
        }
        return true;
    }

    private static String filterLine(String line, String delimiter, List<Integer> skipIndexes) {
        String[] lineParts = line.split(delimiter);
        String filteredLine = IntStream.range(0, lineParts.length)
                .filter(i -> !skipIndexes.contains(i))
                .mapToObj(i -> lineParts[i])
                .collect(Collectors.joining(delimiter));
        return filteredLine + System.lineSeparator();
    }

    private static void writeToFile(String text, String filePath) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(filePath, StandardCharsets.UTF_8, true))
        ) {
            out.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}