package ru.job4j.ood.ocp.violations;

public class Drawer {

    public void draw(Figure figure) {
        if (figure instanceof Circle) {
            System.out.println("draw a circle");
        } else if (figure instanceof Rectangle) {
            System.out.println("draw a rectangle");
        }
    }
}
