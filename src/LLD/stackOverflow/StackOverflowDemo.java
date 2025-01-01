package LLD.stackOverflow;

import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {
    public static void run() {
        StackOverflow system = new StackOverflow();

        //Create Users
        User user1 = system.createUser("user1", "user1@stackOverflow.com");
        User user2 = system.createUser("user2", "user2@stackOverflow.com");
        User user3 = system.createUser("user3", "user3@stackOverflow.com");

        // user1 asks a question
        Question javaQuestion = system.askQuestion(user1, "What is polymorphism in Java?",
                "Can someone explain polymorphism in Java with an example?",
                Arrays.asList("java", "oop"));

        Answer user2Answer = system.answerQuestion(user2, javaQuestion,
                "Polymorphism in Java is the ability of an object to take on many forms...");

        system.addComment(user3, javaQuestion, "Great question! I'm also interested in learning about this.");

        system.addComment(user1, user2Answer, "Thanks for the explanation! Could you provide a code example?");

        system.voteQuestion(user3, javaQuestion, 1);  // Upvote
        system.voteAnswer(user3, user2Answer, 1);  // Upvote

        system.acceptAnswer(user2Answer);

        //user 2 asks a question
        Question pythonQuestion = system.askQuestion(user2, "How to use list comprehensions in Python?",
                "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?",
                Arrays.asList("python", "list-comprehension"));

        Answer user1Answer = system.answerQuestion(user1, pythonQuestion,
                "List comprehensions in Python provide a concise way to create lists...");

        system.voteQuestion(user3, pythonQuestion, 1);  // Upvote
        system.voteAnswer(user3, user1Answer, 1);

        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getName());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + user2Answer.getAuthor().getName() + ":");
        System.out.println(user2Answer.getContent());
        System.out.println("Votes: " + user2Answer.getVoteCount());
        System.out.println("Accepted: " + user2Answer.isAccepted());
        System.out.println("Comments: " + user2Answer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("User1: " + user1.getReputation());
        System.out.println("User2: " + user2.getReputation());
        System.out.println("User3: " + user3.getReputation());

        // Demonstrate search functionality
        System.out.println("\nSearch Results for 'java':");
        List<Question> searchResults = system.searchQuestions("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        System.out.println("\nSearch Results for 'python':");
        searchResults = system.searchQuestions("python");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        // Demonstrate getting questions by user
        System.out.println("\nUser2's Questions:");
        List<Question> bobQuestions = system.searchByUser(user2);
        for (Question q : bobQuestions) {
            System.out.println(q.getTitle());
        }

    }
}
