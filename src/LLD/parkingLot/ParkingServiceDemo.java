package LLD.parkingLot;

import LLD.parkingLot.enums.ParkingSpotType;
import LLD.parkingLot.exceptions.ParkingLotException;
import LLD.parkingLot.interfaces.BillingStrategy;
import LLD.parkingLot.interfaces.Vehicle;
import LLD.parkingLot.models.*;
import LLD.parkingLot.services.ParkingLotNotifier;
import LLD.parkingLot.services.ParkingService;
import LLD.parkingLot.strategy.BillingStrategy.StandardBillingStrategy;
import LLD.parkingLot.strategy.ParkingStrategy.TypeBasedStrategy;

import java.util.Arrays;
import java.util.List;

public class ParkingServiceDemo {
    public static void run() {
        // Define spot types for each level
        List<ParkingSpotType> level1SpotTypes = Arrays.asList(ParkingSpotType.CAR, ParkingSpotType.BIKE, ParkingSpotType.TRUCK);
        List<ParkingSpotType> level2SpotTypes = Arrays.asList(ParkingSpotType.CAR, ParkingSpotType.CAR, ParkingSpotType.TRUCK);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.initialize(2, 3, Arrays.asList(level1SpotTypes, level2SpotTypes));
        BillingStrategy billingStrategy = new StandardBillingStrategy();
        ParkingService parkingService = new ParkingService(parkingLot, new TypeBasedStrategy(),billingStrategy);

        // To switch strategies
       //parkingService.setParkingStrategy(new FirstAvailableStrategy());

        // Create vehicles
        Vehicle car = new Car("ABC123");
        Vehicle bike = new Bike("XYZ789");
        Vehicle truck = new Truck("LMN456");

        // Create observer
        ParkingLotNotifier notifier = new ParkingLotNotifier();

        // Register observer to parking spots in each level
        for (Level level : parkingLot.getLevels()) {
            for (ParkingSpot spot : level.getParkingSpots()) {
                spot.addObserver(notifier);
            }
        }

        try {
            // Park vehicles
            parkingService.parkVehicle(car);
            parkingService.parkVehicle(bike);
            parkingService.parkVehicle(truck);

            // Get available spots
            parkingService.getTotalAvailableSpots();

            // Release vehicles
            parkingService.releaseVehicle(car);
            parkingService.releaseVehicle(bike);
            parkingService.releaseVehicle(truck);

            // Get available spots again
            parkingService.getTotalAvailableSpots();
        } catch (ParkingLotException e) {
            System.err.println(e.getMessage());
        }
    }
}

/*
        * OUTPUT:
        *   Spot 0 is now occupied by ABC123
            CAR: ABC123 is parked successfully.
            Spot 1 is now occupied by XYZ789
            BIKE: XYZ789 is parked successfully.
            Spot 2 is now occupied by LMN456
            TRUCK: LMN456 is parked successfully.
            Total available parking spots: 6
            Spot 0 is now free.
            Given Parking Spot is free: 0 PS: 0
            CAR: ABC123 is released successfully. Hours Parked: 0
            Parking Fee: ₹10.0
            Spot 1 is now free.
            Given Parking Spot is free: 0 PS: 1
            BIKE: XYZ789 is released successfully. Hours Parked: 0
            Parking Fee: ₹10.0
            Spot 2 is now free.
            Given Parking Spot is free: 0 PS: 2
            TRUCK: LMN456 is released successfully. Hours Parked: 0
            Parking Fee: ₹10.0
 * */