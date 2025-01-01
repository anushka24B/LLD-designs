package LLD.stackOverflow;

public class Vote {
    private final User user;
    private final int value; // can make it enum - UPVOTE/ DOWN VOTE

    public Vote(User user, int value) {
        this.user = user;
        this.value = value;
    }

    public User getUser() {
        return this.user;
    }

    public int getValue() {
        return this.value;
    }
}
