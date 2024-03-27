package service;

import model.Post;
import model.Visibility;

public interface IPostService {
    public abstract Post publishPost(String title, String message, Visibility visibility);
}
