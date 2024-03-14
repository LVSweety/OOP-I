package model.user;

public class GuestUser {
    private  long userID;

    private static long autoUserID = 0;
    
    public GuestUser() {
        userID = autoUserID;
        autoUserID++;
    }
    
    public long getUserID() {
        return userID;
    }

}
