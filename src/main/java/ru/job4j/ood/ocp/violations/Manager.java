package ru.job4j.ood.ocp.violations;

public class Manager {

    private final String name;
    private boolean isBusy;

    public Manager(String name) {
        this.name = name;
    }

    public Manager(String name, boolean isBusy) {
        this.name = name;
        this.isBusy = isBusy;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void work() {
        isBusy = true;
        System.out.println("doing some long job");
        isBusy = false;
    }
}
