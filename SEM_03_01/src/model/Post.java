package model;

import java.time.LocalDate;

public class Post {
    private String title        = "New Post";
    private String msg          = "Nothing here yet";
    private LocalDate date      = LocalDate.now();
    private int countOfLikes    = 0;
    
    public Post(String title, String msg) {
        setMessage(msg);
        setTitle(title);
    }
    
    public void setTitle(String title){
        if (title != null && title.length() < 50){
            this.title = title;
        }                                      
    }

    public void setMessage(String msg){
        if (msg != null && msg.length() > 5){
            this.msg = msg;
        }   
    }

    public void addLike(){
        this.countOfLikes++;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public int getLikes() {
        return countOfLikes;
    }
    
    public String getMessage() {
        return msg;
    }
    
    public String getTitle() {
        return title;
    }



}
