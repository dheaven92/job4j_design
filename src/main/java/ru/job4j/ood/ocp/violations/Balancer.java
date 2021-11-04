package ru.job4j.ood.ocp.violations;

import java.util.List;

public class Balancer {

    private static List<Manager> managers;

    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public void balanceManagers() {
        for (Manager manager : managers) {
            if (manager.isBusy()) {
                System.out.println("we need to do something here");
            } else {
                manager.work();
            }
        }
    }
}
