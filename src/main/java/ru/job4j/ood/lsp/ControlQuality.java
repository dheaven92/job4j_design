package ru.job4j.ood.lsp;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {

    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    public void control(Food food) {
        int percentage = getCurrentExpirationPercentage(food);
        if (percentage < 25) {
            setStore(new Warehouse());
        }
        if (percentage >= 25 && percentage <= 75) {
            setStore(new Shop());
        }
        if (percentage > 75) {
            food.setDiscount(true);
            setStore(new Shop());
        }
        if (percentage >= 100) {
            setStore(new Trash());
        }
        store.add(food);
    }

    private int getCurrentExpirationPercentage(Food food) {
        int expiryDays = (int) DAYS.between(food.getExpireDate(), food.getCreateDate());
        int currentDays = (int) DAYS.between(LocalDate.now(), food.getCreateDate());
        return currentDays * 100 / expiryDays;
    }
}
