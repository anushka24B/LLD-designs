package LLD.parkingLot.models;

public class ExitGate {
    private ParkingLot parkingLot;

    public ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void exitVehicle(Vehicle vehicle) {
        parkingLot.releaseVehicle(vehicle);
    }
}
