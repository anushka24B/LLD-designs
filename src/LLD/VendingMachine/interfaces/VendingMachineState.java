package LLD.VendingMachine.interfaces;

import LLD.VendingMachine.models.Money;
import LLD.VendingMachine.models.VendingMachine;

public interface VendingMachineState {
    void insertMoney(VendingMachine machine, Money money);
    void purchaseProduct(VendingMachine machine, String productName);
    void dispenseProduct(VendingMachine machine);
    void returnChange(VendingMachine machine);
}
