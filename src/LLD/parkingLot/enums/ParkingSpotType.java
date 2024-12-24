package LLD.parkingLot.enums;

public enum ParkingSpotType {
    CAR(VehicleType.CAR),
    BIKE(VehicleType.BIKE),
    TRUCK(VehicleType.TRUCK);

    private VehicleType vehicleType;

    ParkingSpotType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}