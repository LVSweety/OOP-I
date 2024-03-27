package main;

import model.person.Person;

import java.time.LocalDateTime;
import java.util.*; 

import model.Driver;
import model.customer.CustomerAsCompany;
import model.customer.CustomerAsPerson;
import model.parcel.Address;
import model.parcel.Parcel;
import model.parcel.ParcelSize;
public class Main {
    public static void main(String[] args) {
        try {
            CustomerAsPerson company = new CustomerAsPerson();
            CustomerAsPerson company2 = new CustomerAsPerson();
            //Driver driver = new Driver(null, null, null, null, 0);

            System.err.println(company);
            System.err.println(company2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
