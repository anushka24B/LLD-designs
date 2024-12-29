package LLD.VendingMachine.enums;

public enum ProductType {
    DRINK("Drink"),
    SNACK("Snack"),
    CANDY("Candy"),
    OTHER("Other");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
