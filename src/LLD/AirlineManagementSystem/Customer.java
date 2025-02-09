package LLD.AirlineManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Reservation> reservations;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
