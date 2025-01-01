package LLD.stackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private int reputation;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    //ask Question
    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(title, content, this, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    // answerQuestion
    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(question, this, content);
        answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    // comment
    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(content, this);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }


    public synchronized void updateReputation(int value) {
        this.reputation += value;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public String getName() {
        return this.name;
    }

    public int getReputation() {
        return this.reputation;
    }
}
