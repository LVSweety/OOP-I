package model.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import service.IPostService;

public abstract class User extends GuestUser implements IPostService {
    private String username;
    protected String nickname;
    private String password     = "PASSWORD";

    protected static ArrayList<User> Users = new ArrayList<User>();

    public abstract void setNickname(String nickname);

    public User (){
        super();
    }

    public User (String username, String password){
        super();
        setPassword(password);
        setUsername(username);
    }

    public void setPassword(String password){
        if(password != null && password.length() > 10){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            this.password = new String(md.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            this.password = "FAILED_PASSWORD";
        }
    }

    public String getNickname(){
        return this.nickname;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    private void setUsername(String username){
        if(username != null){
            this.username = username;
        }
    }

}