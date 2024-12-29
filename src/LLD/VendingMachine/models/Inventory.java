package LLD.VendingMachine.models;

import java.util.HashMap;
import java.util.Map;


public class Inventory {
    private Map<String, Product> productInventory;

    public Inventory() {
        this.productInventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        productInventory.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return productInventory.get(name);
    }

    public boolean isProductAvailable(String name) {
        Product product = getProduct(name);
        return product != null && product.getQuantity() > 0;
    }

    public double getProductQuantity(String name) {
        Product product = getProduct(name);
        return product != null ? product.getQuantity() : 0;
    }

    public void restockProduct(String name, int quantity) {
        Product product = getProduct(name);
        if (product != null) {
            product.restock(quantity);
        } else {
            System.out.println("Product " + name + " does not exist in inventory.");
        }
    }

    public void purchaseProduct(String name) {
        Product product = getProduct(name);
        if (product != null && product.getQuantity() > 0) {
            product.purchase();
        } else {
            throw new IllegalArgumentException("Product is out of stock.");
        }
    }

    public void listAllProducts() {
        for (Product product : productInventory.values()) {
            System.out.println(product.getName());
        }
    }
}
