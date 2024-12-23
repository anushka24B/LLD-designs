import enums.ParkingSpotType;
import exceptions.ParkingLotException;
import models.*;
import services.ParkingService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Define spot types for each level
        List<ParkingSpotType> level1SpotTypes = Arrays.asList(ParkingSpotType.CAR, ParkingSpotType.BIKE, ParkingSpotType.TRUCK);
        List<ParkingSpotType> level2SpotTypes = Arrays.asList(ParkingSpotType.CAR, ParkingSpotType.CAR, ParkingSpotType.TRUCK);

        // Create a parking lot with 2 levels and 3 spots per level
        ParkingLot parkingLot = ParkingLot.getInstance(2, 3, Arrays.asList(level1SpotTypes, level2SpotTypes));
        ParkingService parkingService = new ParkingService(parkingLot);
        // Create vehicles
        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Bike("XYZ789");
        Vehicle truck = new Truck("LMN456");

        try {
            // Park vehicles
            parkingService.parkVehicle(car);
            parkingService.parkVehicle(motorcycle);
            parkingService.parkVehicle(truck);

            // Get available spots
            parkingService.getTotalAvailableSpots();

            // Release vehicles
            parkingService.releaseVehicle(car);
            parkingService.releaseVehicle(motorcycle);
            parkingService.releaseVehicle(truck);

            // Get available spots again
            parkingService.getTotalAvailableSpots();
        } catch (ParkingLotException e) {
            System.err.println(e.getMessage());
        }
    }
}