package ru.job4j.ood.lsp.car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingAreaTest {

    private Area parkingArea;

    @Before
    public void init() {
        parkingArea = new ParkingArea(2, 2);
    }

    @Test
    public void whenParkingTwoPassengerAndTwoStandardTrucks() {
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertTrue(parkingArea.parkCar(new Truck(2)));
        assertTrue(parkingArea.parkCar(new Truck(2)));
    }

    @Test
    public void whenParkingTwoHugeTrucks() {
        assertTrue(parkingArea.parkCar(new Truck(3)));
        assertTrue(parkingArea.parkCar(new Truck(3)));
    }

    @Test
    public void whenParkingOnePassengerAndOneHugeTruck() {
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertTrue(parkingArea.parkCar(new Truck(3)));
    }

    @Test
    public void whenParkingTwoHugeTrucksAndOnePassenger() {
        assertTrue(parkingArea.parkCar(new Truck(3)));
        assertTrue(parkingArea.parkCar(new Truck(3)));
        assertFalse(parkingArea.parkCar(new Passenger()));
    }

    @Test
    public void whenParkingTwoHugeTrucksAndOneStandardTruck() {
        assertTrue(parkingArea.parkCar(new Truck(3)));
        assertTrue(parkingArea.parkCar(new Truck(3)));
        assertFalse(parkingArea.parkCar(new Truck(2)));
    }

    @Test
    public void whenParkingOnePassengerAndTwoTrucks() {
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertTrue(parkingArea.parkCar(new Truck(2)));
        assertTrue(parkingArea.parkCar(new Truck(3)));
    }

    @Test
    public void whenParkingThreePassenger() {
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertTrue(parkingArea.parkCar(new Passenger()));
        assertFalse(parkingArea.parkCar(new Passenger()));
    }

    @Test
    public void whenParkingThreeStandardTruck() {
        assertTrue(parkingArea.parkCar(new Truck(2)));
        assertTrue(parkingArea.parkCar(new Truck(2)));
        assertFalse(parkingArea.parkCar(new Truck(2)));
    }
}