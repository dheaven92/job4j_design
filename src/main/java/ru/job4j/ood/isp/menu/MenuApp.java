package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        Menu menu = new MenuTree();
        menu.add("Task 1", "Task 1.1", new UserAction());
        menu.add("Task 1", "Task 1.2", new UserAction());
        menu.add("Task 1", "Task 1.3", new UserAction());
        menu.add("Task 2", "Task 2.1", new UserAction());
        menu.add("Task 3", null, new UserAction());

        System.out.println(menu);
        System.out.println("Please select menu item:");
        String name = new Scanner(System.in).nextLine();
        Action action = menu.select(name);
        if (action != null) {
            action.act();
        } else {
            System.out.println("No action found for this menu item");
        }
    }
}
