package main;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import model.Driver;
import model.customer.AbstractCustomer;
import model.customer.CustomerAsCompany;
import model.customer.CustomerAsPerson;
import model.parcel.Address;
import model.parcel.City;
import model.parcel.Parcel;
import model.parcel.ParcelSize;
public class Main {

    public static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    public static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();

    public static void main(String[] args) {
        try {
            createNewDriver("Nile", "Green", "185406-24245", "AA123456", (float)1.7);
            createNewDriver("John Albert", "Small", "125606-24245", "AA156756", (float)2);
            createNewDriver("Jeb", "Waffle", "124521-24584", "TD158656", (float)4.7);
            createNewDriver("Bob", "Wurst", "175426-29764", "GA152566", (float)11);
            createNewDriver("Dob", "Burst", "180926-29764", "XF152634", (float)9);
            printDrivers();
            System.out.println("---------------------------------");
            System.out.println(retriveDriverByPersonCode("124521-24584"));
            System.out.println("---------------------------------");
            updateDriverLicenseNoByPersonCode("124521-24584", "FG152566");
            updateDriverExperienceByPersonCode("124521-24584", (float)5);
            System.out.println(retriveDriverByPersonCode("124521-24584"));
            System.out.println("---------------------------------");
            removeDriverByPersonCode("125606-24245");
            printDrivers();
            System.out.println("---------------------------------");
            createNewCustomerAsCompany(new Address(City.RIGA, "Pils", 6), "45456534", "Generic food commpany", "59356778");
            createNewCustomerAsCompany(new Address(City.LIEPAJA, "Pils", 7), "45890034", "Generic metals commpany", "59453567");
            createNewCustomerAsPerson("Grant", "Corn", "839657-58345", new Address(City.DAUGAVPILS, "Upes", 4), "59436574");
            createNewCustomerAsPerson("Jeremy", "Tost", "867857-58345", new Address(City.LIEPAJA, "Pils", 6), "59436574");
            createNewCustomerAsCompany(new Address(City.JELGAVA, "Pils", 6), "45677534", "Generic construction commpany", "59785567");
            createNewCustomerAsCompany(new Address(City.JELGAVA, "Pils", 6), "45938034", "Generic parts commpany", "56666567");
            createNewCustomerAsPerson("Jeff", "Grass", "830567-58345", new Address(City.VENTSPILS, "Upes", 4), "55366574");
            createNewCustomerAsPerson("Bill", "Wheat", "867647-58345", new Address(City.RIGA, "Pils", 6), "59464274");
            printCustomers();
            System.out.println("---------------------------------");
            for (CustomerAsPerson e : retriveAllCustomersAsPerson()){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            for (CustomerAsCompany e : retriveAllCustomersAsCompany()){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.X, false, retriveDriverByPersonCode("124521-24584"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.S, false, retriveDriverByPersonCode("124521-24584"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.X, true, retriveDriverByPersonCode("124521-24584"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.XL, false, retriveDriverByPersonCode("124521-24584"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.L, true, retriveDriverByPersonCode("175426-29764"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.X, true, retriveDriverByPersonCode("175426-29764"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XL, false, retriveDriverByPersonCode("175426-29764"), "3_person_867857-58345");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.L, true, retriveDriverByPersonCode("175426-29764"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.X, true, retriveDriverByPersonCode("124521-24584"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XL, false, retriveDriverByPersonCode("124521-24584"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.L, true, retriveDriverByPersonCode("175426-29764"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.X, false, retriveDriverByPersonCode("175426-29764"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XL, false, retriveDriverByPersonCode("175426-29764"), "1_company_59453567");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.L, true, retriveDriverByPersonCode("175426-29764"), "1_company_59453567");
            for (Parcel e : retriveAllParcelsByCustomerCode("3_person_867857-58345")){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            for (Parcel e : retriveAllParcelsByCity(City.LIEPAJA)){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            for (Parcel e : retriveAllParcelsBySize(ParcelSize.X)){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            System.out.println("1_company_59453567 Pays: " + calculatePriceOfAllCustomerParvelsByCustomerCode("1_company_59453567"));
            int[] stats = retriveStatisticsOfCustomerParcelsSize("1_company_59453567");
            System.out.println("X:"+ stats[0] + " S:" + stats[1] + " M:" + stats[2] + " L:" + stats[3] + " XL:" + stats[4]);
            for (Parcel e : retriveAllParcelsByCustomerCode("1_company_59453567")){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            sortDriversByExperience();
            printDrivers();
            System.out.println("---------------------------------");
            System.out.println("Parcels for today: " + calculateHowManyParcelsTodayDeliveredToSpecificCity(City.LIEPAJA));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDrivers(){
        for (Driver e : allDrivers){
            System.out.println(e);
        }
    }

    public static void printCustomers(){
        for (AbstractCustomer e : allCustomers){
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

    public static ArrayList<CustomerAsCompany> retriveAllCustomersAsCompany() throws Exception {
        ArrayList<CustomerAsCompany> customers = new ArrayList<CustomerAsCompany>();
        for (AbstractCustomer e : allCustomers){
            if (e instanceof CustomerAsCompany) {
                customers.add((CustomerAsCompany) e);
            }
        }
        return customers;
    }

    public static ArrayList<CustomerAsPerson> retriveAllCustomersAsPerson() throws Exception {
        ArrayList<CustomerAsPerson> customers = new ArrayList<CustomerAsPerson>();
        for (AbstractCustomer e : allCustomers){
            if (e instanceof CustomerAsPerson) {
                customers.add((CustomerAsPerson) e);
            }
        }
        return customers;
    }

    public static void createNewCustomerAsPerson(String name, String surname, String personCode, Address address , String phone) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(e.getcID() + "_person_" + personCode))) {
                throw new IllegalArgumentException("[ERROR]: customer exists");
            }
        }
        allCustomers.add(new CustomerAsPerson(name, surname, personCode, address, phone));
    }

    public static void createNewCustomerAsCompany(Address address , String phone, String title, String companyRegNo) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(e.getcID() + "_company_" + companyRegNo))) {
                throw new IllegalArgumentException("[ERROR]: customer exists");
            }
        }
        allCustomers.add(new CustomerAsCompany(address, phone, title, companyRegNo));
    }

    public static void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size, boolean isFargile, Driver driver, String customerCode) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                e.addNewParcel(new Parcel(isFargile, size, plannedDelivery, driver));
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR]: customer not found");
    } 

    public static ArrayList<Parcel> retriveAllParcelsByCustomerCode(String customerCode) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                return e.getParcels();
            }
        }
        throw new IllegalArgumentException("[ERROR]: customer not found");
    }

    public static ArrayList<Parcel> retriveAllParcelsByDriverPersonCode(String personCode) throws Exception {
        if (personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new IllegalArgumentException("[ERROR]: invalid arguments");
        }
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer e : allCustomers){
            for (Parcel p : e.getParcels()) {
                if (p.getDriver().getPersonCode().matches(personCode)) {
                    parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> retriveAllParcelsByCity(City city) throws Exception {
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer e : allCustomers){
            if (e.getAddress().getCity() == city) {
                for (Parcel p : e.getParcels()) {
                        parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> retriveAllParcelsBySize(ParcelSize size) throws Exception {
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer e : allCustomers){
            for (Parcel p : e.getParcels()) {
                if (p.getSize() == size) {
                    parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static float calculatePriceOfAllCustomerParvelsByCustomerCode(String customerCode){
        float sum = 0.0f;
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                for (Parcel p : e.getParcels()) {
                    sum += p.getPrice();
                }
                return sum;
            }
        }
        throw new IllegalArgumentException("[ERROR]: customer not found");
    }

    public static int[] retriveStatisticsOfCustomerParcelsSize(String customerCode) throws Exception {
        int[] stats = {0,0,0,0,0};
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                for (Parcel p : e.getParcels()) {
                    switch (p.getSize()) {
                        case X: 
                            stats[0]++;
                            break;
                        case S:
                            stats[1]++;
                            break;
                        case M:
                            stats[2]++;
                            break; 
                        case L:
                            stats[3]++;
                            break;
                        case XL:
                            stats[4]++;
                            break;
                        default:
                            break;
                    }
                }
                return stats;
            }
        }
        throw new IllegalArgumentException("[ERROR]: customer not found");
    }

    public static void sortDriversByExperience(){
        Comparator<Driver> compareByExperience = Comparator.comparing(Driver::getExperienceInYears);
        allDrivers = allDrivers.stream().sorted(compareByExperience).collect(Collectors.toCollection(ArrayList::new));
    }

    public static int calculateHowManyParcelsTodayDeliveredToSpecificCity(City city) {
        int count = 0;
        for (AbstractCustomer e : allCustomers){
            for ( Parcel p : e.getParcels() ){
                if (p.getPlannedDelivery().getDayOfWeek() == LocalDateTime.now().getDayOfWeek().plus(1)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void generateCustomerAsPersonAndParcel() throws Exception {

    }

    public static void generateCustomerAsCompanyAndParcel() throws Exception {

    }

}


