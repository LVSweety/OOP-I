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

    void setTitle(String title){
        if (title != null && title.length() < 50){
            this.title = title;
        }
    }

    void setMessage(String msg){
        if (msg != null && msg.length() > 5){
            this.msg = msg;
        }   
    }

    void addLike(){
        this.countOfLikes++;
    }

    LocalDate getDate() {
        return date;
    }

    int getLikes() {
        return countOfLikes;
    }

    String getMessage() {
        return msg;
    }

    String getTitle() {
        return title;
    }



}
