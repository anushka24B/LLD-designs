package LLD.parkingLot.interfaces;

import LLD.parkingLot.enums.VehicleType;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;
    private LocalDateTime parkingTime; // Store the parking time

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    // Set the parking time when the vehicle is parked
    public void setParkingTime(LocalDateTime parkingTime) {
        this.parkingTime = parkingTime;
    }

    // Get the parking time
    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    // Calculate hours parked based on parking time
    public long calculateHoursParked() {
        if (parkingTime == null) {
            return 0;
        }
        LocalDateTime currentTime = LocalDateTime.now();
        return java.time.Duration.between(parkingTime, currentTime).toHours();
    }
}
