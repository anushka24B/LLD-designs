package LLD.parkingLot.models;

import LLD.parkingLot.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
