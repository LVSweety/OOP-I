package model;

import java.util.ArrayList;

import model.user.User;

public class Page {
    private String title        = "DEFAULT_TITLE";
    private String description  = "DEFAULT_DESCRIPTION";
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<Post> privatePosts = new ArrayList<Post>();

    public Page(String title, String description){
        if (title != null && description != null && title.length() > 0 && description.length() > 0 && title.length() < 50 && description.length() < 100){
            setTitle(title);
            setDescription(description);
        }
    }

    public void  addPrivatePost(Post post){
    
    }
    
    public void addPublicPost(Post post){

    }

    public void follow(User user){

    }

    public void setTitle(String title){
        if (title != null && title.length() > 0 && title.length() < 50){
            this.title = title;
        }
    }

    public void setDescription(String description) {
        if (description != null && description.length() > 0 && description.length() < 100){
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }
    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }
    public ArrayList<User> getFollowers() {
        return followers;
    }
}
