package LLD.stackOverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable {
    private final int id;
    private final Question question;
    private final User author;
    private final List<Vote> votes;
    private final String content;
    private final List<Comment> comments;
    private final Date creationDate;
    private boolean isAccepted;

    private static final int ACCEPTED_ANSWER_REPUTATION = 15;


    public Answer(Question question, User author,  String content) {
        this.id = generateId();
        this.question = question;
        this.author = author;
        this.votes = new ArrayList<>();
        this.content = content;
        this.comments = new ArrayList<>();
        this.creationDate = new Date();
    }

    private int generateId() {
        return ((int) (System.currentTimeMillis() % Integer.MAX_VALUE));
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(ACCEPTED_ANSWER_REPUTATION);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value!= -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }

        votes.removeIf(v->v.getUser().equals(user));
        Vote vote = new Vote(user, value);
        votes.add(vote);
        user.updateReputation(value*10);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public int getId() {
        return this.id;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isAccepted() {
        return this.isAccepted;
    }
}
