package LLD.coffeeVendingMachine.coffeeType;

import LLD.coffeeVendingMachine.recipe.EspressoRecipe;

public class Espresso extends CoffeeType {
    public Espresso() {
        this.name = "Espresso";
        this.price = 2.5;
        this.recipe = new EspressoRecipe();
    }
}
