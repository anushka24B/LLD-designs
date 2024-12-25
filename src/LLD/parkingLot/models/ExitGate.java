package LLD.parkingLot.models;

import LLD.parkingLot.interfaces.Vehicle;

public class ExitGate {
    private ParkingLot parkingLot;

    public ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void exitVehicle(Vehicle vehicle) {
        parkingLot.releaseVehicle(vehicle);
    }
}
