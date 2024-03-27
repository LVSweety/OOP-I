package main;

import model.person.Person;

import java.time.LocalDateTime;
import java.util.*; 

import model.Driver;
import model.customer.AbstractCustomer;
import model.customer.CustomerAsCompany;
import model.customer.CustomerAsPerson;
import model.parcel.Address;
import model.parcel.Parcel;
import model.parcel.ParcelSize;
public class Main {

    public static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    public static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();

    public static void main(String[] args) {
        try {
            createNewDriver("Nile", "Green", "185406-24245", "AA123456", (float)1.7);
            createNewDriver("John Albert", "Small", "125606-24245", "AA156756", (float)3);
            createNewDriver("Jeb", "Waffle", "124521-24584", "TD158656", (float)1.4);
            createNewDriver("Bob", "Wurst", "175426-29764", "GA152566", (float)5);
            createNewDriver("Dob", "Burst", "180926-29764", "XF152634", (float)5);
            printDtivers();
            System.out.println("---------------------------------");
            System.out.println(retriveDriverByPersonCode("124521-24584"));
            System.out.println("---------------------------------");
            updateDriverLicenseNoByPersonCode("124521-24584", "FG152566");
            updateDriverExperienceByPersonCode("124521-24584", (float)5);
            System.out.println(retriveDriverByPersonCode("124521-24584"));
            System.out.println("---------------------------------");
            removeDriverByPersonCode("125606-24245");
            printDtivers();
            System.out.println("---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDtivers(){
        for (Driver e : allDrivers){
            System.out.println(e);
        }
    }

    public static void createNewDriver(String name, String surname, String personCode, String licenseNo, float experienceInYears) throws Exception { 
        for (Driver e : allDrivers){
            if (e.getPersonCode().equals(personCode)) {
                throw new IllegalArgumentException("[ERROR]: driver exists");
            }
        }
        allDrivers.add(new Driver(name, surname, personCode, licenseNo, experienceInYears));
    }

    public static Driver retriveDriverByPersonCode(String personCode) throws Exception {
        if (personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new IllegalArgumentException("[ERROR]: invalid arguments");
        }
        for (Driver e : allDrivers){
            if (e.getPersonCode().equals(personCode)) {
                return e;
            }
        }
        throw new IllegalArgumentException("[ERROR]: driver does not exist");
    }

    public static void updateDriverLicenseNoByPersonCode(String personCode, String licenseNo) throws Exception {
        if (personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new IllegalArgumentException("[ERROR]: invalid arguments");
        }
        for (Driver e : allDrivers){
            if (e.getPersonCode().equals(personCode)) {
                e.setLicenseNo(licenseNo);
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR]: driver does not exist");
    }

    public static void updateDriverExperienceByPersonCode(String personCode, float experienceInYears) throws Exception {
        if (personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new IllegalArgumentException("[ERROR]: invalid arguments");
        }
        for (Driver e : allDrivers){
            if (e.getPersonCode().equals(personCode)) {
                e.setExperienceInYears(experienceInYears);
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR]: driver does not exist");
    }

    public static void removeDriverByPersonCode(String personCode) throws Exception {
        if (personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new IllegalArgumentException("[ERROR]: invalid arguments");
        }
        for (Driver e : allDrivers){
            if (e.getPersonCode().equals(personCode)) {
                allDrivers.remove(e);
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR]: driver does not exist");
    }
}


