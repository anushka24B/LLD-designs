package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.payment.CardPayment;
import LLD.coffeeVendingMachine.payment.CashPayment;
import LLD.coffeeVendingMachine.payment.Payment;

public class CoffeMachineDemo {
    public static void run() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.displayMenu();
        Payment payment = new CashPayment(5.0); // Pay with $5

        // Make a Latte
        coffeeMachine.makeCoffee("Latte", payment);

        // Check inventory
        coffeeMachine.checkInventory();
        Payment payment2 = new CardPayment("7173ydhkgbb"); // Pay with card

        coffeeMachine.makeCoffee("Espresso", payment2);

        coffeeMachine.checkInventory();
    }
}
