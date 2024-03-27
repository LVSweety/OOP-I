package model.customer;

import java.util.ArrayList;

import model.parcel.Address;
import model.parcel.Parcel;

public abstract class AbstractCustomer {
    private static long auto_cID = 0;

    private long cID;
    private Address address;
    private String phoneNo;
    protected String customerCode;
    private ArrayList<Parcel> parcels = new ArrayList<Parcel>();

    public AbstractCustomer() throws Exception {
        cID = auto_cID++;
        setAddress(new Address());
        setPhoneNo("12345678");
    }
    
    public AbstractCustomer(Address address, String phone) throws Exception {
        cID = auto_cID++;
        setAddress(address);
        setPhoneNo(phone);
    }
    
    public void setPhoneNo(String phoneNo) throws Exception {
        if (phoneNo != null && phoneNo.matches("[0-9]{8}")) {
            this.phoneNo = phoneNo;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");   
    }

    public void setAddress(Address address) throws Exception {
        if (address != null && address instanceof Address) {
            this.address = address;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");  
    }

    abstract public void setCustomerCode() throws Exception;// {

    public void addNewParcel(Parcel parcel) throws Exception {
        if (parcel != null && parcel instanceof Parcel) {
            for (Parcel e : parcels){
                if (e.equals(parcel)){
                    throw new IllegalArgumentException("[ERROR]: parcel exists");
                }
            }
            parcels.add(parcel);
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
    }

    public Address getAddress() {
        return address;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public long getcID() {
        return cID;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public String toString() {
        return "[ " + this.cID + " , " + this.address + " , " + this.customerCode + " , " + this.phoneNo + " ]";
    }
}
