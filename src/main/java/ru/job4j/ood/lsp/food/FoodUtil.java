package ru.job4j.ood.lsp.food;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class FoodUtil {

    private FoodUtil() {

    }

    public static int getCurrentExpirationPercentage(Food food) {
        int expiryDays = (int) DAYS.between(food.getExpireDate(), food.getCreateDate());
        int currentDays = (int) DAYS.between(LocalDate.now(), food.getCreateDate());
        return currentDays * 100 / expiryDays;
    }
}
