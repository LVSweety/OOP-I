package main;

import model.person.Person;
import model.Driver;
public class Main {
    public static void main(String[] args) {
        try {
            Driver driver = new Driver();

            System.err.println(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
