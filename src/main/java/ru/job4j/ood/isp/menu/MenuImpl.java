package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuImpl implements Menu, MenuUserInterface {

    private final List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void addMenuItems(List<MenuItem> items) {
        menuItems.addAll(items);
    }

    @Override
    public void displayMenu() {
        if (menuItems.size() > 0) {
            for (MenuItem menuItem : menuItems) {
                displayMenuRecursively(menuItem, 1);
            }
        }
    }

    @Override
    public void askUserInput() {
        System.out.println();
        System.out.println("Please type in a menu item you like:");
    }

    @Override
    public void respondToUserInput(String requestMenuItemName) {
        if (menuItems.size() > 0) {
            for (MenuItem menuItem : menuItems) {
                handleMenuItemSelectRecursively(menuItem, requestMenuItemName);
            }
        }
    }

    private void displayMenuRecursively(MenuItem menuItem, int indentation) {
        System.out.println("---".repeat(indentation) + " " + menuItem.getName());
        if (menuItem.getSubMenuItems().size() > 0) {
            indentation++;
            for (MenuItem subMenuItem : menuItem.getSubMenuItems()) {
                displayMenuRecursively(subMenuItem, indentation);
            }
        }
    }

    private void handleMenuItemSelectRecursively(MenuItem menuItem, String requestMenuItemName) {
        if (menuItem.getName().equals(requestMenuItemName)) {
            menuItem.handleSelect();
        }
        if (menuItem.getSubMenuItems().size() > 0) {
            for (MenuItem subMenuItem : menuItem.getSubMenuItems()) {
                handleMenuItemSelectRecursively(subMenuItem, requestMenuItemName);
            }
        }
    }
}
