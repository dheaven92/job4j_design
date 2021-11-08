package ru.job4j.ood.lsp.food;

import java.util.List;

public interface Store {

    boolean isFit(Food food);

    boolean add(Food food);

    List<Food> getAllFood();

    void clearAllFood();
}
