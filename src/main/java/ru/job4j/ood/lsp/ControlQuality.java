package ru.job4j.ood.lsp;

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
}
