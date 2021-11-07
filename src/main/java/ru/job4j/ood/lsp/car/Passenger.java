package ru.job4j.ood.lsp.car;

public class Passenger implements Car {

    private final int size;

    public Passenger() {
        this.size = 1;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
