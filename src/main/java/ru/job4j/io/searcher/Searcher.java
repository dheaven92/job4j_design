package ru.job4j.io.searcher;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Searcher {

    private static final String ARGUMENT_DIR = "d";
    private static final String ARGUMENT_FILE = "n";
    private static final String ARGUMENT_TYPE = "t";
    private static final String ARGUMENT_LOG_FILE = "o";
    private static final String TYPE_MASK = "mask";
    private static final String TYPE_REGEX = "regex";

    private static void validateArgs(ArgsName namedArgs) {
        String dir = namedArgs.get(ARGUMENT_DIR);
        String file = namedArgs.get(ARGUMENT_FILE);
        String type = namedArgs.get(ARGUMENT_TYPE);
        String logFile = namedArgs.get(ARGUMENT_LOG_FILE);
        if (dir == null || file == null || logFile == null) {
            throw new IllegalArgumentException(String.format(
                    "Arguments -%1$s -%2$s -%3$s are required! "
                            + "Usage java -jar -%1$s=ROOT_FOLDER -%2$s=FILE_NAME -%3$s=LOG_FILE_NAME -%4$s=%5$s.",
                    ARGUMENT_DIR,
                    ARGUMENT_FILE,
                    ARGUMENT_LOG_FILE,
                    ARGUMENT_TYPE,
                    TYPE_MASK
            ));
        }
        if (!new File(dir).isDirectory()) {
            throw new IllegalArgumentException(String.format("Argument -%s is invalid! Must be a directory.", ARGUMENT_DIR));
        }
        if (type != null && !type.matches(String.format("%s|%s", TYPE_MASK, TYPE_REGEX))) {
            throw new IllegalArgumentException(String.format(
                    "Argument -%s can have value of \"%s\" or \"%s\" only.",
                    ARGUMENT_DIR,
                    TYPE_MASK,
                    TYPE_REGEX
            ));
        }
    }

    private static Predicate<Path> getSearchCondition(String searchType, String fileName) {
        Predicate<Path> condition;
        if (searchType == null) {
            condition = path -> fileName.equals(path.getFileName().toString());
        } else {
            String regex = searchType.equals(TYPE_MASK)
                    ? fileName
                    .replaceAll("\\.", "\\\\.")
                    .replaceAll("\\*", ".*")
                    : fileName;
            condition = path -> path.getFileName().toString().matches(regex);
        }
        return condition;
    }

    private static void writeLogs(String logFile, List<Path> files) {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile))) {
            files.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName namedArgs = ArgsName.of(args);
        validateArgs(namedArgs);
        Predicate<Path> searchCondition = getSearchCondition(
                namedArgs.get(ARGUMENT_TYPE),
                namedArgs.get(ARGUMENT_FILE)
        );
        List<Path> files = Search.search(Path.of(namedArgs.get(ARGUMENT_DIR)), searchCondition);
        writeLogs(namedArgs.get(ARGUMENT_LOG_FILE), files);
    }
}
