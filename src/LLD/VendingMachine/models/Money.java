package LLD.VendingMachine.models;

import LLD.VendingMachine.enums.Coin;
import LLD.VendingMachine.enums.Note;

public class Money {
    private final Object money;

    public Money(Object money) {
        if (!(money instanceof Coin || money instanceof Note)) {
            throw new IllegalArgumentException("Money must be a Coin or a Note.");
        }
        this.money = money;
    }

    public double getAmount() {
        if (money instanceof Coin) {
            return ((Coin) money).getValue();
        } else if (money instanceof Note) {
            return ((Note) money).getValue();
        }
        throw new IllegalStateException("Unknown money type.");
    }

    public String getDenomination() {
        if (money instanceof Coin) {
            return ((Coin) money).name();
        } else if (money instanceof Note) {
            return ((Note) money).name();
        }
        throw new IllegalStateException("Unknown money type.");
    }

    @Override
    public String toString() {
        return "Money{value=" + getAmount() + ", denomination='" + getDenomination() + "'}";
    }
}
