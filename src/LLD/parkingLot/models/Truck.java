package LLD.parkingLot.models;

import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.interfaces.Vehicle;

public class Truck extends Vehicle{

    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}