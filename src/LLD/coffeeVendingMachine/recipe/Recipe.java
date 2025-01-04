package LLD.coffeeVendingMachine.recipe;

import java.util.Map;

public abstract class Recipe {
    protected Map<String, Integer> ingredients;
    public abstract Map<String, Integer> getIngredients();
}
