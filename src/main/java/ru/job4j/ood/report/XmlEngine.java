package ru.job4j.ood.report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XmlEngine implements Report {

    private final Store store;

    public XmlEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            try (StringWriter out = new StringWriter()) {
                List<Employee> employees = store.findBy(em -> true);
                marshaller.marshal(new Employees(employees), out);
                xml = out.getBuffer().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}
