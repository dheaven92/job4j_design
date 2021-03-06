package ru.job4j.ood.report;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HrEngine implements Report {

    private final Store store;

    public HrEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparingDouble(Employee::getSalary)
                .reversed());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
