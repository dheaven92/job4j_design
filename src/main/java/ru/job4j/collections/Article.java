package ru.job4j.collections;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Article {

    private static final String PUNCTUATION_REGEX = "[\\p{Punct}\\s]+";

    public static boolean generateBy(String origin, String line) {
        Map<String, Long> originWordsMap = Arrays.stream(origin.split(PUNCTUATION_REGEX))
                .collect(Collectors.groupingBy(
                        String::toLowerCase,
                        Collectors.counting()
                ));
        Map<String, Long> lineWordsMap = Arrays.stream(line.split(PUNCTUATION_REGEX))
                .collect(Collectors.groupingBy(
                        String::toLowerCase,
                        Collectors.counting()
                ));
        for (String s : lineWordsMap.keySet()) {
            if (!originWordsMap.containsKey(s)
                    || lineWordsMap.get(s) > originWordsMap.get(s)) {
                return false;
            }
        }
        return true;
    }
}
