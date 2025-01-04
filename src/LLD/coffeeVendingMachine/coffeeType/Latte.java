package LLD.coffeeVendingMachine.coffeeType;

import LLD.coffeeVendingMachine.recipe.LatteRecipe;

public class Latte extends CoffeeType{
    public Latte() {
        this.name = "Latte";
        this.price =  3.5;
        this.recipe = new LatteRecipe();
    }
}
