package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class JaxbDemo {

    public static void main(String[] args) throws Exception {
        VisaApplication application = new VisaApplication(
                "8a9003e3",
                1,
                new Declarant(
                        "Bob",
                        "Smith",
                        38,
                        true,
                        List.of("passport", "driver license")
                )
        );
        JAXBContext context = JAXBContext.newInstance(VisaApplication.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(application, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            VisaApplication result = (VisaApplication) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
