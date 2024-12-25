package LLD.parkingLot.interfaces;

import LLD.parkingLot.models.ParkingLot;

public interface ParkingStrategy {
    boolean parkVehicle(ParkingLot parkingLot, Vehicle vehicle);
}
