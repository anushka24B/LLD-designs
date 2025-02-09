package LLD.AirlineManagementSystem;

public class BookingService {

    public boolean bookSeat(Seat seat, Customer customer) {
        if (seat.tryBookSeat(seat.getVersion())) {
            Reservation reservation = new Reservation(customer, seat);
            customer.addReservation(reservation);
            System.out.println("Seat " + seat.getSeatNumber() + " booked successfully for " + customer.getName());
            return true;
        } else {
            System.out.println("Booking failed. Seat " + seat.getSeatNumber() + " is already booked.");
            return false;
        }
    }

    public void cancelReservation(Reservation reservation) {
        reservation.cancel();
        reservation.getSeat().setAvailable(true);  // Make the seat available again
        System.out.println("Reservation for seat " + reservation.getSeat().getSeatNumber() + " is cancelled.");
    }

    public Payment processPayment(double amount, String paymentMethod) {
        Payment payment = new Payment(amount, paymentMethod);
        payment.completePayment();  // Mark payment as completed
        System.out.println("Payment of " + amount + " using " + paymentMethod + " completed.");
        return payment;
    }
}
