package LLD.coffeeVendingMachine.recipe;

import java.util.HashMap;
import java.util.Map;

public class LatteRecipe extends Recipe {
    public LatteRecipe() {
        this.ingredients = new HashMap<>();
        this.ingredients.put("coffee", 1);
        ingredients.put("milk", 2);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
