package LLD.VendingMachine.models;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.states.IdleState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VendingMachine {
    private Inventory inventory;
    private List<Money> insertedMoney;
    private VendingMachineState currentState;
    private Product selectedProduct;

    private static VendingMachine instance; //SINGLETON Pattern
    private final Lock stateLock = new ReentrantLock();

    private VendingMachine() {
        this.inventory = new Inventory();
        this.insertedMoney = new ArrayList<>();
        this.currentState = new IdleState();  // Initial state
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            synchronized (VendingMachine.class) {
                if (instance == null) {
                    return new VendingMachine();
                }
            }
        }
        return instance;
    }

    public void addProductToInventory(Product product) {
        inventory.addProduct(product);
    }

    public void insertMoney(Money money) {
        currentState.insertMoney(this, money);
    }

    public void selectProduct(String productName) {
        currentState.purchaseProduct(this, productName);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void returnChange() {
        double changeAmount = calculateTotalInsertedAmount() - selectedProduct.getPrice();
        if (changeAmount > 0) {
            System.out.println("Returning change: $" + changeAmount);
            giveChange(changeAmount);
        }
        this.insertedMoney.clear();
    }

    public double calculateTotalInsertedAmount() {
        double totalAmount = 0;
        for (Money money : this.insertedMoney) {
            totalAmount += money.getAmount();
        }
        return totalAmount;
    }

    private void giveChange(double changeAmount) {
        while (changeAmount > 0) {
            if (changeAmount >= 1) {
                System.out.println("Returning Note: $1");
                changeAmount -= 1;
            } else if (changeAmount >= 0.25) {
                System.out.println("Returning Coin: $0.25");
                changeAmount -= 0.25;
            } else if (changeAmount >= 0.1) {
                System.out.println("Returning Coin: $0.10");
                changeAmount -= 0.1;
            } else if (changeAmount >= 0.05) {
                System.out.println("Returning Coin: $0.05");
                changeAmount -= 0.05;
            } else if (changeAmount >= 0.01) {
                System.out.println("Returning Coin: $0.01");
                changeAmount -= 0.01;
            }
        }
    }

    public boolean isProductAvailable(String productCode) {
        return inventory.isProductAvailable(productCode);
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    public void setState(VendingMachineState state) {
        stateLock.lock();  // Lock to prevent race conditions during state transitions
        try {
            this.currentState = state;
        } finally {
            stateLock.unlock();
        }
    }

    public void showInventory() {
        inventory.listAllProducts();
    }

    public boolean hasSufficientFunds(String productName) {
        Product product = inventory.getProduct(productName);
        if (product != null) {
            double totalInsertedAmount = calculateTotalInsertedAmount();
            return totalInsertedAmount >= product.getPrice();
        }
        return false;
    }

    public List<Money> getInsertedMoney() {
        return insertedMoney;
    }

    // Add money to the inserted money list
    public void addMoney(Money money) {
        insertedMoney.add(money);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

}
