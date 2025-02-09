package LLD.AirlineManagementSystem;

import java.util.List;

public class Flight {
    private String flightNumber;
    private List<Seat> seats;

    public Flight(String flightNumber, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
