package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.communicationsInterfaces.CustomerShort;
import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.repo.ICompanyCustomerRepo;
import lv.lvs.backend.repo.IPrivateCustomerRepo;
import lv.lvs.backend.service.ICustomerHandlerService;

@Service
public class CustomerHandlerImp implements ICustomerHandlerService{

    @Autowired
    private IPrivateCustomerRepo privateRepo;
    @Autowired
    private ICompanyCustomerRepo companyRepo;

    @Override
    public ArrayList<CustomerShort> sellectAllCustomer() throws Exception {
        if ( privateRepo.count() == 0 || companyRepo.count() == 0 ) throw new FileNotFoundException();

        ArrayList<CustomerShort> result = new ArrayList<CustomerShort>();

        ArrayList<PrivateCustomer> privates = (ArrayList<PrivateCustomer>) privateRepo.findAll();
        ArrayList<CompanyCustomer> companies = (ArrayList<CompanyCustomer>) companyRepo.findAll();

        for (PrivateCustomer e : privates) {
            result.add(new CustomerShort(e.getCustomerCode()));
        }
        for (CompanyCustomer e : companies) {
            result.add(new CustomerShort(e.getCustomerCode()));
        }

        return result;
    }

    @Override
    public ArrayList<PrivateCustomer> sellectAllPrivateCustomer() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellectAllPrivateCustomer'");
    }

    @Override
    public ArrayList<CompanyCustomer> sellectAllCompanyCustomer() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellectAllCompanyCustomer'");
    }

    @Override
    public PrivateCustomer sellectPrivateCustomerByID(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellectPrivateCustomerByID'");
    }

    @Override
    public CompanyCustomer sellectCompanyCustomerByID(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellectCompanyCustomerByID'");
    }

}
