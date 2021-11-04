package ru.job4j.ood.srp;

import org.junit.Test;
import ru.job4j.ood.report.Employee;
import ru.job4j.ood.report.HtmlEngine;
import ru.job4j.ood.report.MemStore;
import ru.job4j.ood.report.Report;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HtmlEngineTest {

    @Test
    public void whenHtmlReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, null, 100);
        store.add(worker);
        Report engine = new HtmlEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("<table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append(worker.getName())
                .append("</td>")
                .append("<td>")
                .append(worker.getHired())
                .append("</td>")
                .append("<td>")
                .append(worker.getFired())
                .append("</td>")
                .append("<td>")
                .append(worker.getSalary())
                .append("</td>")
                .append("</tr>")
                .append("</table>");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}