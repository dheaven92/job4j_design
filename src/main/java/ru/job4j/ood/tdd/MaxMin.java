package ru.job4j.ood.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compareAndGet(value, (a, b) -> Objects.compare(a, b, comparator) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compareAndGet(value, (a, b) -> Objects.compare(a, b, comparator) < 0);
    }

    private <T> T compareAndGet(List<T> value, BiPredicate<T, T> comparison) {
        if (value == null || value.size() == 0) {
            return null;
        }
        T rsl = value.get(0);
        for (T v : value) {
            if (comparison.test(v, rsl)) {
                rsl = v;
            }
        }
        return rsl;
    }
}
