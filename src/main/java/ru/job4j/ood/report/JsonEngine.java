package ru.job4j.ood.report;

import com.google.gson.Gson;

import java.util.function.Predicate;

public class JsonEngine implements Report {

    private final Store store;

    public JsonEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new Gson().toJson(store.findBy(em -> true));
    }
}
