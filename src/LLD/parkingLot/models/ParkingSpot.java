package LLD.parkingLot.models;

import LLD.parkingLot.enums.ParkingSpotType;
import LLD.parkingLot.interfaces.ParkingSpotObserver;
import LLD.parkingLot.interfaces.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpot {
    private List<ParkingSpotObserver> observers = new ArrayList<>();
    private int number;
    private ParkingSpotType type;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
        this.isOccupied = false;
    }

    public void addObserver(ParkingSpotObserver observer) {
        observers.add(observer);
    }

    private void notifyObserversOccupied() {
        for (ParkingSpotObserver observer : observers) {
            observer.onSpotOccupied(this, vehicle);
        }
    }

    private void notifyObserversFreed() {
        for (ParkingSpotObserver observer : observers) {
            observer.onSpotFreed(this);
        }
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
        vehicle.setParkingTime(LocalDateTime.now());
        notifyObserversOccupied();
        return true;
    }

    public synchronized void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isOccupied = false;
        notifyObserversFreed();
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
