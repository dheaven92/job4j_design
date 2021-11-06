package ru.job4j.ood.isp.menu;

import java.util.List;

public interface MenuItem {

    String getName();

    void handleSelect();

    void addSubMenuItems(List<MenuItem> subMenuItems);

    List<MenuItem> getSubMenuItems();
}
