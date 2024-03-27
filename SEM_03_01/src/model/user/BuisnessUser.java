package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.Visibility;
public class BuisnessUser extends User {
    
    private String VATno;
    private ArrayList<Page> pages = new ArrayList<Page>();
    
    public BuisnessUser(String username, String password, String VATno, String nickName){
        super(username, password);
        setNickname(nickname);
        setVATno(VATno);
    }

    public void addPage(String title, String description){
        pages.add(new Page(title, description));
    }

    public void addPostToPage(String pageTitle, String title, String message, Visibility visibility){
        for(Page p : pages){
            if(p.getTitle().toLowerCase() == pageTitle.toLowerCase()){
                if(visibility == Visibility.globalPost){
                    Post newPost = publishPost(pageTitle, pageTitle, visibility);
                    p.getPublicPosts().add(newPost);
                } else {
                    Post newPost = publishPost(pageTitle, pageTitle, visibility);
                    p.getPrivatePosts().add(newPost);
                }
            }
        }
    }

    @Override
    public Post publishPost(String title, String message, Visibility visibility) {
        if (title != null && message != null && visibility != null){
            Post newPost = new Post(title, message);
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

    public void setVATno(String VATno) {
        if (VATno != null && VATno.matches("[A-Z]{2}[0-9]{11}")) {
            this.VATno = VATno;
        } else {
            this.VATno = "LV00000000000";
        }
        
    }
    public String getVATno() {
        return VATno;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "[" + getUserID() + "]:"; 
    }
    
}
