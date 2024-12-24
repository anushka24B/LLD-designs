package LLD.parkingLot.models;

import LLD.parkingLot.enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;

    private static ParkingLot instance;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(int numberOfLevels, int spotsPerLevel, List<List<ParkingSpotType>> spotTypesPerLevel) {
        if (instance == null) {
            instance = new ParkingLot(numberOfLevels, spotsPerLevel, spotTypesPerLevel);
        }
        return instance;
    }

    public ParkingLot(int numberOfLevels, int spotsPerLevel, List<List<ParkingSpotType>> spotTypesPerLevel) {
        levels = new ArrayList<>();
        for(int i=0; i<numberOfLevels; i++) {
            levels.add(new Level(i,spotsPerLevel, spotTypesPerLevel.get(i)));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void releaseVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.releaseVehicle(vehicle)) return;
        }
    }

    public int getTotalAvailableSpots() {
        int totalSpots = 0;
        for(Level level: levels) {
            totalSpots += level.getAvailableSpots();
        }
        return totalSpots;
    }
}
