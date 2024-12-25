package LLD.parkingLot.interfaces;

public interface BillingStrategy {
    double calculateParkingFee(Vehicle vehicle, long hoursParked);
}
