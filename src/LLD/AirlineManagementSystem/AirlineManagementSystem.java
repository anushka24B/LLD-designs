package LLD.AirlineManagementSystem;

import java.util.Arrays;

public class AirlineManagementSystem {
    /*
    * Flow -> create flight, seats, customers
    * bookSeat
    * processPayment
    * addReservation
    * */

    public static void main(String[] args) {
        // Create Seats
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);
        Seat seat3 = new Seat(3);

        // Create Flight
        Flight flight = new Flight("AA123", Arrays.asList(seat1, seat2, seat3));

        // Create Customer
        Customer customer1 = new Customer("John Doe", "johndoe@example.com");

        // Create BookingService and PaymentService
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        // Booking Process
        boolean isBooked = bookingService.bookSeat(seat1, customer1);
        if (isBooked) {
            // If booking is successful, process the payment
            Payment payment = paymentService.processPayment(500.00, "CARD");

            // Complete the reservation with the payment
            Reservation reservation = new Reservation(customer1, seat1);
            reservation.completePayment(payment);

            // Add reservation to the customer
            customer1.addReservation(reservation);
        }

        // Print all reservations for the customer
        System.out.println("\nReservations for customer " + customer1.getName() + ":");
        for (Reservation res : customer1.getReservations()) {
            System.out.println("Seat " + res.getSeat().getSeatNumber() + " Status: " + res.getStatus());
        }

        // Cancel the reservation
        bookingService.cancelReservation(customer1.getReservations().get(0));

        // Print all reservations for the customer again after cancellation
        System.out.println("\nReservations for customer " + customer1.getName() + " after cancellation:");
        for (Reservation res : customer1.getReservations()) {
            System.out.println("Seat " + res.getSeat().getSeatNumber() + " Status: " + res.getStatus());
        }
    }
}

