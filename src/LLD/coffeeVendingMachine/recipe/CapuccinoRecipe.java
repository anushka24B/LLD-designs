package LLD.coffeeVendingMachine.recipe;

import java.util.HashMap;
import java.util.Map;

public class CapuccinoRecipe extends Recipe {

    public CapuccinoRecipe() {
        this.ingredients = new HashMap<>();
        this.ingredients.put("coffee", 1); // 1 unit of coffee for Cappuccino
        this.ingredients.put("milk", 1); // 1 unit of milk for Cappuccino
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
