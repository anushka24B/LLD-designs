package LLD.parkingLot.strategy.ParkingStrategy;

import LLD.parkingLot.interfaces.ParkingStrategy;
import LLD.parkingLot.interfaces.Vehicle;
import LLD.parkingLot.models.Level;
import LLD.parkingLot.models.ParkingLot;
import LLD.parkingLot.models.ParkingSpot;

// Park based on vehicle type
public class TypeBasedStrategy implements ParkingStrategy {
    @Override
    public boolean parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        for (Level level : parkingLot.getLevels()) {
            for (ParkingSpot spot : level.getParkingSpots()) {
                if (!spot.isOccupied() && spot.getType().getVehicleType().equals(vehicle.getType())) {
                    return spot.assignVehicle(vehicle);
                }
            }
        }
        return false;
    }
}
