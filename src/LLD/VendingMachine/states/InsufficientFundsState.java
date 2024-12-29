package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public class InsufficientFundsState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine machine, Money money) {
        System.out.println("Money inserted: " + money);
        machine.addMoney(money);
        if (machine.hasSufficientFunds(machine.getSelectedProduct().getName())) {
            machine.setState(new ProductSelectedState());
        } else {
            machine.setState(new MoneyInsertedState());
        }
    }

    @Override
    public void purchaseProduct(VendingMachine machine, String productName) {
        System.out.println("Insufficient funds for the selected product.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Not enough funds to dispense product.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("Not enough funds to return change.");
    }
}
