package services;

import exceptions.ParkingLotException;
import models.ParkingLot;
import models.Vehicle;

public class ParkingService {
    private ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) throws ParkingLotException {
        if(parkingLot.parkVehicle(vehicle)) {
            System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " is parked successfully.");
            return true;
        }
        throw new ParkingLotException("No Parking Spot found");
    }

    public synchronized void releaseVehicle(Vehicle vehicle) {
        parkingLot.releaseVehicle(vehicle);
        System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " is released successfully.");
    }

    public int getTotalAvailableSpots() {
        int availableSpots = parkingLot.getTotalAvailableSpots();
        System.out.println("Total available parking spots: " + availableSpots);
        return availableSpots;
    }
}
