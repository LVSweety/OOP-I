package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.Customer;

public interface ICustomerHandlerService {
    
    public abstract ArrayList<Customer> sellectAll() throws Exception;

    public abstract Customer sellectById(int id) throws Exception;

    public abstract Customer removeById(int id) throws Exception;

    public abstract Customer updateCustomer(int id, String name, String surname) throws Exception;

    public abstract Customer insertCustomer(String name, String surname) throws Exception;

}
