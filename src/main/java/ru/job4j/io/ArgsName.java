package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments can't be empty");
        }
        for (String arg : args) {
            Pair pair = parseArg(arg);
            values.put(pair.key, pair.value);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair parseArg(String arg) {
        try {
            String[] parts = arg.split("=");
            return new Pair(parts[0].replace("-", ""), parts[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument syntax");
        }
    }
}
