package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.coffeeType.CoffeeType;
import LLD.coffeeVendingMachine.payment.Payment;
import LLD.coffeeVendingMachine.recipe.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeMachine {
    private List<CoffeeType> menu;
    private Inventory inventory;
    private CoffeeFactory coffeeFactory;

    public CoffeeMachine() {
        this.inventory = Inventory.getInstance();
        this.coffeeFactory = CoffeeFactory.getInstance();
        this.menu = new ArrayList<>(Arrays.asList(
                coffeeFactory.createCoffee("Espresso"),
                coffeeFactory.createCoffee("Cappuccino"),
                coffeeFactory.createCoffee("Latte")
        ));
    }

    public void displayMenu() {
        for (CoffeeType coffee : menu) {
            System.out.println(coffee.getName() + " - " + coffee.getPrice());
        }
    }

    // Makes coffee after receiving payment and checking inventory
    public void makeCoffee(String type, Payment payment) {
        CoffeeType coffee = coffeeFactory.createCoffee(type);
        Recipe recipe = coffee.getRecipe();

        if (inventory.checkStock(recipe)) {
            double price = coffee.getPrice();
            if (payment.processPayment(price)) {
                inventory.reduceStock(recipe);
                dispenseCoffee(coffee);
            } else {
                System.out.println("Payment failed. Insufficient amount.");
            }
        } else {
            System.out.println("Insufficient ingredients to make " + type);
        }
    }

    // Dispenses the coffee
    private void dispenseCoffee(CoffeeType coffee) {
        System.out.println("Dispensing: " + coffee.getName());
    }

    // Checks the inventory for available stock
    public void checkInventory() {
        inventory.displayStock();
    }
}
