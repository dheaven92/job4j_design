package ru.job4j.ood.lsp.car;

public class Passenger implements Car {

    private final int size;

    public Passenger(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
