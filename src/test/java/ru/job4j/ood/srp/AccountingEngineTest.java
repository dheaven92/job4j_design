package ru.job4j.ood.srp;

import org.junit.Test;
import ru.job4j.ood.report.AccountingEngine;
import ru.job4j.ood.report.Employee;
import ru.job4j.ood.report.MemStore;
import ru.job4j.ood.report.Report;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AccountingEngineTest {

    @Test
    public void whenAccountingReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountingEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("$").append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}