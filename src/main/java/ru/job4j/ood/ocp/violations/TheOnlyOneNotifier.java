package ru.job4j.ood.ocp.violations;

import ru.job4j.ood.srp.violations.Task;

public final class TheOnlyOneNotifier {

    public void notify(Task task) {
        System.out.println("notify " + task);
    }
}
