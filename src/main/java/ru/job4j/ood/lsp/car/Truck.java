package ru.job4j.ood.lsp.car;

public class Truck implements Car {

    private final int size;

    public Truck(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Invalid truck size");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
