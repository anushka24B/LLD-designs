package LLD.parkingLot.models;

import LLD.parkingLot.interfaces.Vehicle;

public class EntryGate {
    private ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean enterVehicle(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }
}
