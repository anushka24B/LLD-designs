package LLD.VendingMachine.states;

import LLD.VendingMachine.interfaces.VendingMachineState;
import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public class ReturnChangeState implements VendingMachineState {
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
        System.out.println("Product already dispensed.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("Returning change...");
        machine.returnChange();
        machine.setState(new IdleState());
    }
}
