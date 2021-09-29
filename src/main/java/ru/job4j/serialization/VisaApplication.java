package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class VisaApplication {

    private final String identifier;
    private final int priority;
    private final Declarant declarant;

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

    public static void main(String[] args) {
        final VisaApplication application = new VisaApplication(
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
        Gson gson = new GsonBuilder().create();
        String applicationJson = gson.toJson(application);
        System.out.println("json:\n" + applicationJson);
        final VisaApplication deserializedApplication = gson.fromJson(applicationJson, VisaApplication.class);
        System.out.println("object:\n" + deserializedApplication);
    }
}
