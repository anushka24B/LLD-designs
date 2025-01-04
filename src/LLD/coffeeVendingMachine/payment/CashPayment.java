package LLD.coffeeVendingMachine.payment;

public class CashPayment implements Payment {
    private double amountPaid;

    public CashPayment(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amountPaid >= amount) {
            double change = amountPaid - amount;
            System.out.println("Payment successful. Change: " + change);
            return true;
        } else {
            System.out.println("Insufficient cash. Payment failed.");
            return false;
        }
    }
}
