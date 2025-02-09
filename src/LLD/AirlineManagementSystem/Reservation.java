package LLD.AirlineManagementSystem;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private Seat seat;
    private String status;  // CONFIRMED, CANCELLED
    private Date reservationDate;
    private Payment payment;

    public Reservation(Customer customer, Seat seat) {
        this.customer = customer;
        this.seat = seat;
        this.status = "CONFIRMED";
        this.reservationDate = new Date();
    }

    public void cancel() {
        this.status = "CANCELLED";
    }

    public Seat getSeat() {
        return seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void completePayment(Payment payment) {
        this.payment = payment;
        this.status = "PAID";  // Update status to PAID after successful payment
    }
}
