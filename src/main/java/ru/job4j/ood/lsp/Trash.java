package ru.job4j.ood.lsp;

import java.util.LinkedList;
import java.util.List;

public class Trash implements Store {

    private static final List<Food> STORAGE = new LinkedList<>();

    @Override
    public void add(Food food) {
        STORAGE.add(food);
        System.out.println(food + " got in trash");
    }

    @Override
    public List<Food> getAllFood() {
        return STORAGE;
    }
}
