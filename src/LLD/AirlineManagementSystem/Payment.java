package LLD.AirlineManagementSystem;

public class Payment {
    private double amount;
    private String paymentMethod;  // CARD, UPI, etc.
    private String status;  // COMPLETED, FAILED

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = "IN PROGRESS";
    }

    public void completePayment() {
        this.status = "COMPLETED";
    }

    public String getStatus() {
        return status;
    }
}