package LLD.parkingLot.models;

import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.interfaces.Vehicle;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
