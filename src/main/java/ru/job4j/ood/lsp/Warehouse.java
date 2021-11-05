package ru.job4j.ood.lsp;

import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Store {

    private static final List<Food> STORAGE = new LinkedList<>();

    @Override
    public boolean isFit(Food food) {
        int percentage = FoodUtil.getCurrentExpirationPercentage(food);
        if (percentage < 25) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Food food) {
        STORAGE.add(food);
        System.out.println(food + " got in warehouse");
    }

    @Override
    public List<Food> getAllFood() {
        return STORAGE;
    }
}
