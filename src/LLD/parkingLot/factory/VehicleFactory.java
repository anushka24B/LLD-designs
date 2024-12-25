package LLD.parkingLot.factory;

import LLD.parkingLot.models.Bike;
import LLD.parkingLot.models.Car;
import LLD.parkingLot.models.Truck;
import LLD.parkingLot.interfaces.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate) {
        switch (type) {
            case "Car":
                return new Car(licensePlate);
            case "Bike":
                return new Bike(licensePlate);
            case "Truck":
                return new Truck(licensePlate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}