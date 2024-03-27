package model.user;

import model.Visibility;
import java.util.ArrayList;

import model.Post;

public class PrivateUser extends User {

    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<User> followers = new ArrayList<User>();
    

    public PrivateUser(){
        super();
    }

    public PrivateUser(String username, String nickname, String password){
        super(username, password);
        setNickname(nickname);

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

    public void addPrivatePost(Post post) {
        if(post != null){
            this.privatePosts.add(post);
        }
    }
    public void addPublicPost(Post post) {
        if(post != null){
            this.publicPosts.add(post);
        }
    }

    @Override
    public Post publishPost(String title, String message, Visibility visibility) {
        if (title != null && message != null && visibility != null){
            Post newPost = new Post(title, message);
            if (visibility == Visibility.globalPost){
                publicPosts.add(newPost);
            } else {
                privatePosts.add(newPost);
            }
            return newPost;
        }
        return null;
        
    }

    @Override
    public void setNickname(String nickname) {
        if(nickname != null){
            this.nickname = nickname;
        }
    }

}
