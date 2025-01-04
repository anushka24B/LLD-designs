package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.coffeeType.*;

public class CoffeeFactory {

    private static CoffeeFactory instance;

    // Private constructor to prevent instantiation
    private CoffeeFactory() { }

    // Singleton to ensure only one instance of CoffeeFactory
    public static synchronized CoffeeFactory getInstance() {
        if (instance == null) {
            instance = new CoffeeFactory();
        }
        return instance;
    }

    public CoffeeType createCoffee(String coffeeType) {
        switch (coffeeType.toLowerCase()) {
            case "espresso":
                return new Espresso();
            case "cappuccino":
                return new Capuccino();
            case "latte":
                return new Latte();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + coffeeType);
        }
    }
}
