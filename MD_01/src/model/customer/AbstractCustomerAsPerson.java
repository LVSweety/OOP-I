package model.customer;

import model.parcel.Address;
import model.person.Person;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer {

    protected Person person;

    public AbstractCustomerAsPerson() throws Exception {
        super();
        this.person = new Person(); 
    }

    public AbstractCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) throws Exception {
        super(address, phone);
        this.person = new Person(name, surname, personCode); 
    }

}
