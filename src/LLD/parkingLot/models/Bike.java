package LLD.parkingLot.models;

import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.interfaces.Vehicle;

public class Bike extends Vehicle{

    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}
