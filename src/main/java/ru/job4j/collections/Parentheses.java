package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static boolean valid(char[] data) {
        List<Character> openingParentheses = new ArrayList<>();
        List<Character> closingParentheses = new ArrayList<>();

        for (char c : data) {
            if (openingParentheses.size() == closingParentheses.size()) {
                openingParentheses = new ArrayList<>();
                closingParentheses = new ArrayList<>();
            }
            if (openingParentheses.size() == 0 && c == ')') {
                return false;
            }
            if (c == '(') {
                openingParentheses.add(c);
            } else {
                closingParentheses.add(c);
            }
        }

        return openingParentheses.size() == closingParentheses.size();
    }
}
