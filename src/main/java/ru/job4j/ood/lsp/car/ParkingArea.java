package ru.job4j.ood.lsp.car;

import java.util.ArrayList;
import java.util.List;

public class ParkingArea implements Area {

    private final static int TRUCK_LOT_SIZE = 2;

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
        if (car.getSize() == 1 && freePassengerLots >= 1) {
            passengerLots.add(car);
            return true;
        }
        int freeTruckLots = truckLotsCapacity - truckLots.size();
        if (car.getSize() == TRUCK_LOT_SIZE && freeTruckLots * TRUCK_LOT_SIZE >= TRUCK_LOT_SIZE) {
            truckLots.add(car);
            return true;
        }
        if (car.getSize() >= TRUCK_LOT_SIZE && freeTruckLots > 0) {
            int extraCarSpaceRequired = Math.abs(freeTruckLots * TRUCK_LOT_SIZE - car.getSize());
            if (freePassengerLots >= extraCarSpaceRequired) {
                truckLots.add(car);
                for (int i = 0; i < extraCarSpaceRequired; i++) {
                    passengerLots.add(car);
                }
                return true;
            }
        }
        return false;
    }
}
