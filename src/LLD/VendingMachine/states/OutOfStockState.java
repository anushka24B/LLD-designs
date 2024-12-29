package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public class OutOfStockState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine machine, Money money) {
        System.out.println("Money inserted: " + money);
        machine.setState(new MoneyInsertedState());
    }

    @Override
    public void purchaseProduct(VendingMachine machine, String productName) {
        System.out.println("Selected product is out of stock.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Can't dispense, product is out of stock.");
        machine.setState(new ReturnChangeState());
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("Returning back money");
    }
}
