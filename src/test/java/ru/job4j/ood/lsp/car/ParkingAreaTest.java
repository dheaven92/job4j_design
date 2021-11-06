package ru.job4j.ood.lsp.car;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ParkingAreaTest {

    private Area parkingArea;

    @Before
    public void init() {
        parkingArea = new ParkingArea(2, 1);
    }

    @Ignore
    @Test
    public void whenParkingTwoPassengerAndOneTrucks() {
        parkingArea.parkCar(new Passenger(1));
        parkingArea.parkCar(new Passenger(1));
        parkingArea.parkCar(new Truck(2));
    }

    @Ignore
    @Test
    public void whenParkingTwoTrucks() {
        parkingArea.parkCar(new Truck(2));
        parkingArea.parkCar(new Truck(2));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenParkingOnePassengerAndTwoTrucks() {
        parkingArea.parkCar(new Passenger(1));
        parkingArea.parkCar(new Truck(2));
        parkingArea.parkCar(new Truck(2));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenParkingThreePassenger() {
        parkingArea.parkCar(new Passenger(1));
        parkingArea.parkCar(new Passenger(1));
        parkingArea.parkCar(new Passenger(1));
    }
}