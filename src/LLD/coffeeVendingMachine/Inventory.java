package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    private Map<String, Integer> ingredients;

    private Inventory() {
        ingredients = new HashMap<>();
        ingredients.put("coffee", 100);
        ingredients.put("milk", 100);
        ingredients.put("sugar", 100);
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    // Checks if stock is enough for a given recipe
    public boolean checkStock(Recipe recipe) {
        for (Map.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
            if (ingredients.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void reduceStock(Recipe recipe) {
        for (Map.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
            ingredients.put(entry.getKey(), ingredients.get(entry.getKey()) - entry.getValue());
        }

        // After stock is reduced, check if any ingredient is low
        checkLowStock();
    }

    public void checkLowStock() {
        List<String> lowStockIngredients = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            if (entry.getValue() < 20) { // Threshold for low stock
                lowStockIngredients.add(entry.getKey());
            }
        }

        // Notify if ingredients are low
        if (!lowStockIngredients.isEmpty()) {
            System.out.println("Warning: The following ingredients are running low: " + lowStockIngredients);
        }
    }

    public void displayStock() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
