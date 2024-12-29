package LLD.VendingMachine.models;

import LLD.VendingMachine.enums.ProductType;

public class Product {
    private String code;
    private String name;
    private double price;
    private double quantity;
    private ProductType productType;

    //Constructor

    public Product(String code, String name, double price, int quantity, ProductType productType) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
    }

    //Getter Setters - later as needed
    public String getCode() {
        return this.code;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    //restock
    public void restock(int quantity) {
        this.quantity += quantity;
    }

    //purchase
    public synchronized void purchase() {
        if (this.quantity > 0) {
            this.quantity--;
        } else {
            throw new IllegalArgumentException("Product is out of stock.");
        }
    }

}
