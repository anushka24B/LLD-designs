package LLD.VendingMachine;

import LLD.VendingMachine.enums.Coin;
import LLD.VendingMachine.enums.Note;
import LLD.VendingMachine.enums.ProductType;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.Product;
import LLD.VendingMachine.models.VendingMachine;

public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Create Products
        Product soda = new Product("P001", "Soda", 1.50, 10, ProductType.DRINK);
        Product chips = new Product("P002", "Chips", 1.20, 5, ProductType.SNACK);
        Product candyBar = new Product("P003", "Candy Bar", 1.00, 8, ProductType.CANDY);
        Product granolaBar = new Product("P004", "Granola Bar", 1.80, 5, ProductType.SNACK);

        // Add products to the inventory
        vendingMachine.addProductToInventory(soda);
        vendingMachine.addProductToInventory(chips);
        vendingMachine.addProductToInventory(candyBar);
        vendingMachine.addProductToInventory(granolaBar);

        // Show inventory
        System.out.println("Current Inventory:");
        vendingMachine.showInventory();

        // Insert money (coins and notes)
        Money coin1 = new Money(Coin.QUARTER);
        Money note1 = new Money(Note.ONE);
        System.out.println("\nInserting money...");
        vendingMachine.insertMoney(coin1);
        vendingMachine.insertMoney(note1);

        vendingMachine.selectProduct("Chips");

        vendingMachine.dispenseProduct();
    }

}