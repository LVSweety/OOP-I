package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.communicationsInterfaces.CustomerShort;
import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;

public interface ICustomerHandlerService {

    public abstract ArrayList<CustomerShort> sellectAllCustomer() throws Exception;

    public abstract ArrayList<PrivateCustomer> sellectAllPrivateCustomer() throws Exception;

    public abstract ArrayList<CompanyCustomer> sellectAllCompanyCustomer() throws Exception;
    
    public abstract PrivateCustomer sellectPrivateCustomerByID(int id) throws Exception;

    public abstract CompanyCustomer sellectCompanyCustomerByID(int id) throws Exception;

    // public abstract void deleteDriverByID(int id) throws Exception;
}
