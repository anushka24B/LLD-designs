package LLD.stackOverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable {
    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Tag> tags;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Vote> votes;


    public Question(String title, String content, User author, List<String> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.tags = new ArrayList<>();;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for (String tagName : tags) {
            this.tags.add(new Tag(tagName));
        }
    }

    private int generateId() {
        return ((int) (System.currentTimeMillis() % Integer.MAX_VALUE));
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
        //upvote, downvote
        if (value != 1 && value!= -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }

        votes.removeIf(v->v.getUser().equals(user));
        Vote vote = new Vote(user, value);
        votes.add(vote);
        user.updateReputation(value*5);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }


    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public User getAuthor() {
        return this.author;
    }

    public int getId() {
        return this.id;
    }
}
