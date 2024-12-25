package LLD.parkingLot.strategy.ParkingStrategy;

import LLD.parkingLot.interfaces.ParkingStrategy;
import LLD.parkingLot.interfaces.Vehicle;
import LLD.parkingLot.models.Level;
import LLD.parkingLot.models.ParkingLot;

// Park in the first available spot
public class FirstAvailableStrategy implements ParkingStrategy {
    @Override
    public boolean parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        for (Level level : parkingLot.getLevels()) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}