package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public class MoneyInsertedState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine machine, Money money) {
        machine.addMoney(money);
        System.out.println("Money inserted: " + money);
    }

    @Override
    public void purchaseProduct(VendingMachine machine, String productName) {
        System.out.println("Product selected: " + productName);
        if (machine.hasSufficientFunds(productName) && machine.isProductAvailable(productName)) {
            machine.setSelectedProduct(machine.getInventory().getProduct(productName));
            machine.setState(new ProductSelectedState());
        } else {
            if (!machine.isProductAvailable(productName)) {
                machine.setState(new OutOfStockState());
            } else {
                machine.setState(new InsufficientFundsState());
            }
        }
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Please select a product.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("No product selected yet.");
    }
}
