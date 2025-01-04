package LLD.coffeeVendingMachine.payment;

public class CardPayment implements Payment {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        // Simulating card payment processing
        System.out.println("Processing card payment...");
        return true;
    }
}