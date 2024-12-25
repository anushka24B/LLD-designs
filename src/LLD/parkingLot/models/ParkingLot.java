package LLD.parkingLot.models;

import LLD.parkingLot.enums.ParkingSpotType;
import LLD.parkingLot.interfaces.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private boolean isInitialized = false;

    private static ParkingLot instance;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
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

    // Method to initialize the ParkingLot with levels and parking spots
    public void initialize(int levelsCount, int spotsPerLevel, List<List<ParkingSpotType>> spotTypes) throws IllegalStateException {
        if (isInitialized) {
            throw new IllegalStateException("ParkingLot is already initialized.");
        }
        levels = new ArrayList<>();
        for(int i=0; i<levelsCount; i++) {
            levels.add(new Level(i,spotsPerLevel, spotTypes.get(i)));
        }

        isInitialized = true;  // Mark the lot as initialized
    }

    public int getTotalAvailableSpots() {
        int totalSpots = 0;
        for(Level level: levels) {
            totalSpots += level.getAvailableSpots();
        }
        return totalSpots;
    }

    public List<Level> getLevels(){
        return this.levels;
    }
}
