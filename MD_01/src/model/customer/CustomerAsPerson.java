package model.customer;

import model.parcel.Address;

public class CustomerAsPerson extends AbstractCustomerAsPerson{

    public CustomerAsPerson() throws Exception {
        super();
        setCustomerCode();
    }

    public CustomerAsPerson(String name, String surname, String personCode, Address address, String phone) throws Exception {
        super(name, surname, personCode, address, phone);
        setCustomerCode();
    }

    

    @Override
    public void setCustomerCode() {
        super.customerCode = super.getcID() + "_person_" + super.person.getPersonCode();
    }

    public String toString() {
        return "[ " + super.getcID() + " , " + super.getAddress() + " , " + super.getCustomerCode() + " , " + super.getPhoneNo() + " ]:" + super.person ;
    }

}
