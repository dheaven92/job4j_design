package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void control(Food food) {
        stores.forEach(store -> {
            boolean added = store.add(food);
            if (!added) {
                System.out.println("Could not store " + food);
            }
        });
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store store : stores) {
            foodList.addAll(store.getAllFood());
            store.clearAllFood();
        }
        for (Food food : foodList) {
            this.control(food);
        }
    }
}
