package main;

import model.person.Person;

import java.time.LocalDateTime;
import java.util.*; 

import model.Driver;
import model.parcel.Address;
import model.parcel.Parcel;
import model.parcel.ParcelSize;
public class Main {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("deprecation")
            Parcel p = new Parcel(false, ParcelSize.L, LocalDateTime.now().plusDays(10), new Driver());
            //Driver driver = new Driver(null, null, null, null, 0);

            System.err.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
