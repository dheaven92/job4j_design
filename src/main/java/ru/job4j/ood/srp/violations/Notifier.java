package ru.job4j.ood.srp.violations;

public interface Notifier {

    void notify(Task task);

    boolean validateTask(Task task);
}
