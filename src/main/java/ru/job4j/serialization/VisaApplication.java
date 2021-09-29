package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "visa_application")
public class VisaApplication {

    @XmlAttribute
    private String identifier;

    @XmlAttribute
    private int priority;

    private Declarant declarant;

    public VisaApplication() {

    }

    public VisaApplication(String identifier, int priority, Declarant declarant) {
        this.identifier = identifier;
        this.priority = priority;
        this.declarant = declarant;
    }

    @Override
    public String toString() {
        return "VisaApplication{"
                + "identifier='" + identifier + '\''
                + ", priority=" + priority
                + ", declarant=" + declarant
                + '}';
    }
}
