package ru.job4j.ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.ood.report.Employee;
import ru.job4j.ood.report.MemStore;
import ru.job4j.ood.report.Report;
import ru.job4j.ood.report.ReportEngine;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenEngineReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}