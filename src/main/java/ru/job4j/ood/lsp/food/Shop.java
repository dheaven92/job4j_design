package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> storage = new LinkedList<>();

    @Override
    public boolean isFit(Food food) {
        int percentage = FoodUtil.getCurrentExpirationPercentage(food);
        if (percentage >= 25 && percentage <= 75) {
            return true;
        }
        if (percentage > 75 && percentage < 100) {
            food.setDiscount(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Food food) {
        if (isFit(food)) {
            storage.add(food);
            System.out.println(food + " got in shop");
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getAllFood() {
        return new ArrayList<>(storage);
    }
}
