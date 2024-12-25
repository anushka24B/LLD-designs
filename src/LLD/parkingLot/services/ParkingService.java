package LLD.parkingLot.services;

import LLD.parkingLot.exceptions.ParkingLotException;
import LLD.parkingLot.interfaces.BillingStrategy;
import LLD.parkingLot.interfaces.ParkingStrategy;
import LLD.parkingLot.models.ParkingLot;
import LLD.parkingLot.interfaces.Vehicle;

public class ParkingService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;
    private BillingStrategy billingStrategy;

    public ParkingService(ParkingLot parkingLot, ParkingStrategy parkingStrategy, BillingStrategy billingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        this.billingStrategy = billingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy strategy) {
        this.parkingStrategy = strategy;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) throws ParkingLotException {
        if(parkingStrategy.parkVehicle(parkingLot, vehicle)) {
            System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " is parked successfully.");
            return true;
        }
        throw new ParkingLotException("No Parking Spot found");
    }

    public synchronized void releaseVehicle(Vehicle vehicle) {
        parkingLot.releaseVehicle(vehicle);

        long hoursParked = vehicle.calculateHoursParked();
        System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " is released successfully. Hours Parked: " + hoursParked);

        // Calculate parking fee based on the billing strategy
        double parkingFee = billingStrategy.calculateParkingFee(vehicle, hoursParked);
        System.out.println("Parking Fee: ₹" + parkingFee);
    }

    public int getTotalAvailableSpots() {
        int availableSpots = parkingLot.getTotalAvailableSpots();
        System.out.println("Total available parking spots: " + availableSpots);
        return availableSpots;
    }
}
