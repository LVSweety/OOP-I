package service.implementation;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.User;
import service.IGuestUserService;

public class AllUserServiceImpl implements IGuestUserService{

    @Override
    public ArrayList<User> findUsers(String key) {
        if (key != null){

        }
        return null;
    }

    @Override
    public ArrayList<Page> findPages(String key) {
        if (key != null){

        }
        return null;
    }

    @Override
    public ArrayList<Post> findPost(String key) {
        if (key != null){

        }
        return null;
    }

}
