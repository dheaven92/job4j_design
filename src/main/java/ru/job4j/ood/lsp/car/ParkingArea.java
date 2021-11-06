package ru.job4j.ood.lsp.car;

public class ParkingArea implements Area {

    private final int passengerLots;
    private final int truckLots;

    public ParkingArea(int passengerLots, int truckLots) {
        this.passengerLots = passengerLots;
        this.truckLots = truckLots;
    }

    @Override
    public boolean parkCar(Car car) {
        return false;
    }
}
