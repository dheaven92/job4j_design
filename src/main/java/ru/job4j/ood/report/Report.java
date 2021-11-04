package ru.job4j.ood.report;

import java.util.function.Predicate;

public interface Report {

    String generate(Predicate<Employee> filter);
}
