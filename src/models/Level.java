package models;

import enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    private int totalAvailableSpots;
    private List<ParkingSpot> parkingSpots;
    //Constructor
    public Level(int levelNumber, int noOfSpots,List<ParkingSpotType> spotTypes) {
        this.levelNumber = levelNumber;
        this.totalAvailableSpots = noOfSpots;
        this.parkingSpots = new ArrayList<>();
        for(int i=0; i<noOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, spotTypes.get(i%spotTypes.size())));
        }
    }

    //methods
    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.assignVehicle(vehicle))  {
                System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " is parked at level: "+ levelNumber + " PS: "+ parkingSpot.getNumber());
                totalAvailableSpots--;
                return true;
            }
        }
        return false;
    }

    public synchronized boolean releaseVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.getVehicle() !=null && parkingSpot.getVehicle().equals(vehicle)) {
                parkingSpot.removeVehicle(vehicle);
                System.out.println("Given Parking Spot is free: "+ levelNumber + " PS: "+ parkingSpot.getNumber());
                totalAvailableSpots++;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSpots() {
        return totalAvailableSpots;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
