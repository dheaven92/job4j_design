package ru.job4j.ood.isp.menu;

public interface Menu {

    void add(String parentName, String childName, Action action);

    Action select(String name);
}
