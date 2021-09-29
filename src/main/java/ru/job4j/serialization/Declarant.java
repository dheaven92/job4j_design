package ru.job4j.serialization;

import java.util.List;

public class Declarant {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final boolean hasJob;
    private final List<String> documents;

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
