package LLD.parkingLot.strategy.BillingStrategy;

import LLD.parkingLot.interfaces.BillingStrategy;
import LLD.parkingLot.interfaces.Vehicle;

public class StandardBillingStrategy implements BillingStrategy {
    private static final double RATE_PER_HOUR = 5.0; // Flat rate per hour

    @Override
    public double calculateParkingFee(Vehicle vehicle, long hoursParked) {
        return 10 + RATE_PER_HOUR * hoursParked;
    }
}
