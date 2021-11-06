package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        MenuItem exitMenuItem = new MenuItemImpl("Drinks");
        MenuItem breakfastMenuItem = new MenuItemImpl("Breakfasts");
        breakfastMenuItem.addSubMenuItems(List.of(
                new MenuItemImpl("Scramble eggs"),
                new MenuItemImpl("Scramble eggs with bacon and tomatoes"),
                new MenuItemImpl("Roasty-toasty")
        ));
        MenuItem dinnerMenuItem = new MenuItemImpl("Dinners");
        dinnerMenuItem.addSubMenuItems(List.of(
                new MenuItemImpl("Dad's supper"),
                new MenuItemImpl(
                        "Big dad's supper",
                        List.of(new MenuItemImpl("Big dad's supper with extra drink"))
                )
        ));
        MenuImpl menu = new MenuImpl();
        menu.addMenuItems(List.of(
                breakfastMenuItem,
                dinnerMenuItem,
                exitMenuItem
        ));
        menu.displayMenu();
        menu.askUserInput();
        Scanner userInput = new Scanner(System.in);
        menu.respondToUserInput(userInput.nextLine());
    }
}
