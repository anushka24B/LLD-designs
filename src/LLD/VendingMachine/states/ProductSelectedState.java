package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.Product;
import LLD.VendingMachine.models.VendingMachine;

public class ProductSelectedState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine machine, Money money) {
        System.out.println("Money already inserted.");
    }

    @Override
    public void purchaseProduct(VendingMachine machine, String productName) {
        System.out.println("Product already selected.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Product selectedProduct = machine.getSelectedProduct();
        if (selectedProduct != null && selectedProduct.getQuantity() > 0) {
            System.out.println("Dispensing product: " + selectedProduct.getName());
            machine.getInventory().purchaseProduct(selectedProduct.getName());
            machine.returnChange();  // Return change after dispensing product
            machine.setState(new IdleState());
        } else {
            System.out.println("Product out of stock.");
            machine.setState(new OutOfStockState());  // Transition to OutOfStockState if product is unavailable
        }
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("Returning change now...");
    }
}
