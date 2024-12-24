package LLD.parkingLot.models;

import LLD.parkingLot.enums.ParkingSpotType;

public class ParkingSpot {
    private int number;
    private ParkingSpotType type;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
        this.isOccupied = false;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (!isOccupied && vehicle.getType() == type.getVehicleType()) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public synchronized void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
