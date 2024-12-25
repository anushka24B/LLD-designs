package LLD.parkingLot.services;

import LLD.parkingLot.interfaces.ParkingSpotObserver;
import LLD.parkingLot.interfaces.Vehicle;
import LLD.parkingLot.models.ParkingSpot;

public class ParkingLotNotifier implements ParkingSpotObserver {
    @Override
    public void onSpotOccupied(ParkingSpot parkingSpot, Vehicle vehicle) {
        System.out.println("Spot " + parkingSpot.getNumber() + " is now occupied by " + vehicle.getLicensePlate());
    }

    @Override
    public void onSpotFreed(ParkingSpot parkingSpot) {
        System.out.println("Spot " + parkingSpot.getNumber() + " is now free.");
    }
}