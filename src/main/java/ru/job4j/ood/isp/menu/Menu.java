package ru.job4j.ood.isp.menu;

import java.util.List;

public interface Menu {

    void addMenuItems(List<MenuItem> menuItems);

    void displayMenu();
}
