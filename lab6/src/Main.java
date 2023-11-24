import java.io.*;
import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String email;
    private int userID;

    public User(String username, String email, int userID) {
        this.username = username;
        this.email = email;
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    public void createUserProfile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("user_" + userID + ".txt"));
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("Email: " + email);
            writer.close();
            System.out.println("User profile created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating user profile: " + e.getMessage());
        }
    }
}

class Post {
    private int postID;
    private String content;
    private int userID;

    public Post(int postID, String content, int userID) {
        this.postID = postID;
        this.content = content;
        this.userID = userID;
    }

    public void createPost() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("post_" + postID + ".txt"));
            writer.write("User ID: " + userID);
            writer.newLine();
            writer.write("Content: " + content);
            writer.close();
            System.out.println("Post created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating post: " + e.getMessage());
        }
    }
    public int getPostID(){
        return this.postID;
    }
    public void deletePost() {
        File postFile = new File("post_" + postID + ".txt");
        if (postFile.exists()) {
            if (postFile.delete()) {
                System.out.println("Post deleted successfully.");
            } else {
                System.out.println("Failed to delete post.");
            }
        } else {
            System.out.println("Post not found.");
        }
    }
}

class Comment {
    private int commentID;
    private String text;
    private int postID;

    public Comment(int commentID, String text, int postID) {
        this.commentID = commentID;
        this.text = text;
        this.postID = postID;
    }

    public void createComment() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("comment_" + commentID + ".txt"));
            writer.write("Post ID: " + postID);
            writer.newLine();
            writer.write("Text: " + text);
            writer.close();
            System.out.println("Comment created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating comment: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {

        User user = new User("tassadaq", "tassadaqq.abid@gmail.com", 1);
        user.createUserProfile();

        Post post = new Post(1, "Today I am happy with 69 others.", user.getUserID());
        post.createPost();
        post.deletePost();

        Comment comment = new Comment(1, "Nice post!", post.getPostID());
        comment.createComment();


    }
}
