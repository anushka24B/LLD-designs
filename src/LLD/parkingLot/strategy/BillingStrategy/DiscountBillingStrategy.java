package LLD.parkingLot.strategy.BillingStrategy;

import LLD.parkingLot.interfaces.BillingStrategy;
import LLD.parkingLot.interfaces.Vehicle;

public class DiscountBillingStrategy implements BillingStrategy {
    private static final double RATE_PER_HOUR = 5.0;
    private static final int DISCOUNT_THRESHOLD_HOURS = 8;
    private static final double DISCOUNT_PERCENTAGE = 0.1; // 10% discount

    @Override
    public double calculateParkingFee(Vehicle vehicle, long hoursParked) {
        double totalFee = RATE_PER_HOUR * hoursParked;
        if (hoursParked >= DISCOUNT_THRESHOLD_HOURS) {
            totalFee = totalFee * (1 - DISCOUNT_PERCENTAGE); // Apply discount
        }
        return totalFee;
    }
}
