package ru.job4j.ood.lsp.violations;

import java.util.List;

public class Airport {

    public static void main(String[] args) {
        List<Aircraft> aircrafts = List.of(new Plane(), new Helicopter());
        for (Aircraft aircraft : aircrafts) {
            aircraft.takeoff();
            aircraft.land();
        }
        for (Aircraft aircraft : aircrafts) {
            System.out.println("Today's lunch is " + aircraft.serveLunch().toUpperCase());
        }
    }
}
