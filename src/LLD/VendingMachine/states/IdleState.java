package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public class IdleState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine machine, Money money) {
        System.out.println("Money inserted: " + money);
        machine.addMoney(money);
        machine.setState(new MoneyInsertedState());
    }

    @Override
    public void purchaseProduct(VendingMachine machine, String productCode) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Please insert money and select a product.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("No money inserted, nothing to return.");
    }
}
