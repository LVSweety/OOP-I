package main;

import model.Visibility;

import model.user.PrivateUser;

public class Main {

	public static void main(String[] args) {
		PrivateUser user1 = new PrivateUser("mrBIG", "BIG MAN", "no_password");
		PrivateUser user2 = new PrivateUser();

		user1.publishPost("JAVA", "insert text here", Visibility.globalPost);
	}

}
