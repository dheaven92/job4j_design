package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JSONDemo {

    public static void main(String[] args) {
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

        JSONObject declarantJson = new JSONObject("{\"firstName\": \"Bob\", "
                + "\"lastName\": \"Smith\", "
                + "\"age\": 38, "
                + "\"hasJob\": true}");
        JSONArray documentsJson = new JSONArray();
        documentsJson.put("passport");
        documentsJson.put("driver license");
        declarantJson.put("documents", documentsJson);

        JSONObject applicationJson = new JSONObject();
        applicationJson.put("identifier", application.getIdentifier());
        applicationJson.put("priority", application.getPriority());
        applicationJson.put("declarant", declarantJson);

        System.out.println("JSONObject:\n" + applicationJson);
        System.out.println("Object to json:\n" + new JSONObject(application));
    }
}
