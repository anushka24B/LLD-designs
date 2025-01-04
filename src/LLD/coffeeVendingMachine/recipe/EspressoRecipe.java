package LLD.coffeeVendingMachine.recipe;

import java.util.HashMap;
import java.util.Map;

public class EspressoRecipe extends Recipe {
    public EspressoRecipe() {
        this.ingredients = new HashMap<>();
        this.ingredients.put("coffee", 1);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
