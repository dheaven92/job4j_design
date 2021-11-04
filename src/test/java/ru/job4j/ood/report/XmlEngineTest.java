package ru.job4j.ood.report;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class XmlEngineTest {

    @Test
    public void whenXmlReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String isoNow = dateFormat.format(now.getTime());
        Employee worker = new Employee("Ivan", now, null, 100);
        store.add(worker);
        Report engine = new XmlEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append("<employee>")
                .append("<name>")
                .append(worker.getName())
                .append("</name>")
                .append("<hired>")
                .append(isoNow)
                .append("</hired>")
                .append("<salary>")
                .append(worker.getSalary())
                .append("</salary>")
                .append("</employee>")
                .append("</employees>");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}