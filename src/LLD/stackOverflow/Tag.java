package LLD.stackOverflow;

public class Tag {
    private final int id;
    private final String name;

    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getName() {
        return this.name;
    }
}
