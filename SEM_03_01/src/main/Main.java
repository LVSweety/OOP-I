package main;

import java.util.ArrayList;

import model.Page;
import model.Visibility;
import model.user.BuisnessUser;
import model.user.GuestUser;
import model.user.PrivateUser;

public class Main {

	private static ArrayList<GuestUser> users = new ArrayList<GuestUser>();
	public static void main(String[] args) {
		BuisnessUser BU1 = new BuisnessUser("BURGER", "MEAT", "LV29348395846", "HESIS");
		users.add(BU1);
		users.add(new PrivateUser("mrBIG", "BIG MAN", "no_password"));

		BU1.addPage("VE HESS", "VE HESS BIG NEWS");
		BU1.addPostToPage("VE HESS", "BIG NEWS", "FREE STUFF AT OUR PLACE", Visibility.globalPost);

		for(Page p: BU1.getPages()) {
			System.out.println(p);
		}

		for(GuestUser user : users) {
			System.out.println(user);
		}
	}

}
