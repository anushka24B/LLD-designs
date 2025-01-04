package LLD.coffeeVendingMachine.coffeeType;

import LLD.coffeeVendingMachine.recipe.Recipe;

public abstract class CoffeeType {
    protected String name;
    protected double price;
    protected Recipe recipe;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
