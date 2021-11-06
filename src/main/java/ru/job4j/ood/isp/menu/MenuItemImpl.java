package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItemImpl implements MenuItem {

    private final String name;

    private List<MenuItem> subMenuItems = new ArrayList<>();

    public MenuItemImpl(String name) {
        this.name = name;
    }

    public MenuItemImpl(String name, List<MenuItem> subMenuItems) {
        this.name = name;
        this.subMenuItems = subMenuItems;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void handleSelect() {
        System.out.println("You clicked on " + getName() + " menu item");
    }

    @Override
    public void addSubMenuItems(List<MenuItem> subMenuItems) {
        this.subMenuItems.addAll(subMenuItems);
    }

    @Override
    public List<MenuItem> getSubMenuItems() {
        return new ArrayList<>(subMenuItems);
    }
}
