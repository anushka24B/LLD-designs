package LLD.coffeeVendingMachine.coffeeType;

import LLD.coffeeVendingMachine.recipe.CapuccinoRecipe;

public class Capuccino extends CoffeeType{
    public Capuccino() {
        this.name = "Capuccino";
        this.price = 3.0;
        this.recipe = new CapuccinoRecipe();
    }
}
