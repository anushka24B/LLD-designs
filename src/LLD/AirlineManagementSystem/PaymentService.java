package LLD.AirlineManagementSystem;

public class PaymentService {
    public Payment processPayment(double amount, String paymentMethod) {
        return new Payment(amount, paymentMethod);
    }
}
