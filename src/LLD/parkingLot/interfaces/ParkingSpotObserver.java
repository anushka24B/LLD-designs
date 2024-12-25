package LLD.parkingLot.interfaces;

import LLD.parkingLot.models.ParkingSpot;

public interface ParkingSpotObserver {
    void onSpotOccupied(ParkingSpot parkingSpot, Vehicle vehicle);
    void onSpotFreed(ParkingSpot parkingSpot);
}
