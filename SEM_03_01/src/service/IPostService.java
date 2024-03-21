package service;

import model.Visibility;

public interface IPostService {
    public abstract void publishPost(String title, String message, Visibility visibility);
}
