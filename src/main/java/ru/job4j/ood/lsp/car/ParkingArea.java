package ru.job4j.ood.lsp.car;

import java.util.ArrayList;
import java.util.List;

public class ParkingArea implements Area {

    private final int passengerLotsCapacity;
    private final int truckLotsCapacity;
    private final List<Car> passengerLots;
    private final List<Car> truckLots;

    public ParkingArea(int passengerLotsCapacity, int truckLotsCapacity) {
        this.passengerLotsCapacity = passengerLotsCapacity;
        this.truckLotsCapacity = truckLotsCapacity;
        this.passengerLots = new ArrayList<>(passengerLotsCapacity);
        this.truckLots = new ArrayList<>(truckLotsCapacity);
    }

    @Override
    public boolean parkCar(Car car) {
        int freePassengerLots = passengerLotsCapacity - passengerLots.size();
        if (car.getSize() == Passenger.PASSENGER_SIZE && freePassengerLots >= Passenger.PASSENGER_SIZE) {
            passengerLots.add(car);
            return true;
        }
        int freeTruckLots = truckLotsCapacity - truckLots.size();
        if (car.getSize() > Passenger.PASSENGER_SIZE && freeTruckLots > 0) {
            truckLots.add(car);
            return true;
        }
        if (car.getSize() > Passenger.PASSENGER_SIZE && freeTruckLots == 0) {
            if (freePassengerLots >= car.getSize()) {
                for (int i = 0; i < car.getSize(); i++) {
                    passengerLots.add(car);
                }
                return true;
            }
        }
        return false;
    }
}
