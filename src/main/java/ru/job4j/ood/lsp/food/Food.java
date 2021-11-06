package ru.job4j.ood.lsp.food;

import java.time.LocalDate;

public class Food {

    private final String name;
    private final LocalDate createDate;
    private final LocalDate expireDate;
    private double price;
    private boolean isDiscounted = false;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setDiscount(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
        if (isDiscounted) {
            price = price / 2;
        }
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", price=" + price
                + ", isDiscounted=" + isDiscounted
                + '}';
    }
}
