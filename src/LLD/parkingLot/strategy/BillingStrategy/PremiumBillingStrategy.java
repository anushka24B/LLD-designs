package LLD.parkingLot.strategy.BillingStrategy;

import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.interfaces.BillingStrategy;
import LLD.parkingLot.interfaces.Vehicle;

public class PremiumBillingStrategy implements BillingStrategy {
    private static final double CAR_RATE_PER_HOUR = 5.0;
    private static final double TRUCK_RATE_PER_HOUR = 10.0; // Higher rate for trucks

    @Override
    public double calculateParkingFee(Vehicle vehicle, long hoursParked) {
        double rate = vehicle.getType() == VehicleType.TRUCK ? TRUCK_RATE_PER_HOUR : CAR_RATE_PER_HOUR;
        return rate * hoursParked;
    }
}

