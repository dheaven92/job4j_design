package ru.job4j.ood.lsp.violations;

public class Helicopter extends Aircraft {

    public Helicopter() {
        this.toggleChassis();
    }

    @Override
    public String serveLunch() {
        return null;
    }
}
