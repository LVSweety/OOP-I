package service;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.User;

public interface IGuestUserService {
    public abstract ArrayList<User> findUsers(String key);
    public abstract ArrayList<Page> findPages(String key);
    public abstract ArrayList<Post> findPost(String key);
}
