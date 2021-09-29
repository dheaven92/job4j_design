package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "declarant")
public class Declarant {

    @XmlAttribute(name = "first_name")
    private String firstName;

    @XmlAttribute(name = "last_name")
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlAttribute(name = "has_job")
    private boolean hasJob;

    @XmlElementWrapper
    @XmlElement(name = "document")
    private List<String> documents;

    public Declarant() {

    }

    public Declarant(String firstName, String lastName, int age, boolean hasJob, List<String> documents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hasJob = hasJob;
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Declarant{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", hasJob=" + hasJob
                + ", documents=" + documents
                + '}';
    }
}
