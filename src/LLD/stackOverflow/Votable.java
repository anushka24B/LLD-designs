package LLD.stackOverflow;

public interface Votable {
    void vote(User user, int value);
    int getVoteCount();
}
