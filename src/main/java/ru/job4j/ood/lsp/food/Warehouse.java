package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> storage = new LinkedList<>();

    @Override
    public boolean isFit(Food food) {
        int percentage = FoodUtil.getCurrentExpirationPercentage(food);
        return percentage < 25;
    }

    @Override
    public boolean add(Food food) {
        if (isFit(food)) {
            storage.add(food);
            System.out.println(food + " got in warehouse");
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getAllFood() {
        return new ArrayList<>(storage);
    }

    @Override
    public void clearAllFood() {
        storage = new LinkedList<>();
    }
}
