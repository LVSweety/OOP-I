package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.communicationsInterfaces.CustomerShort;
import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.model.parcel.Address;
import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.person.Person;
import lv.lvs.backend.repo.IAddressRepo;
import lv.lvs.backend.repo.ICompanyCustomerRepo;
import lv.lvs.backend.repo.IPersonRepo;
import lv.lvs.backend.repo.IPrivateCustomerRepo;
import lv.lvs.backend.service.ICustomerHandlerService;

@Service
public class CustomerHandlerImp implements ICustomerHandlerService {

    @Autowired
    private IPrivateCustomerRepo privateRepo;
    @Autowired
    private ICompanyCustomerRepo companyRepo;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private IAddressRepo addressRepo;

    @Override
    public ArrayList<CustomerShort> sellectAllCustomer() throws Exception {
        if (privateRepo.count() == 0 || companyRepo.count() == 0)
            throw new FileNotFoundException();

        ArrayList<CustomerShort> result = new ArrayList<CustomerShort>();

        ArrayList<PrivateCustomer> privates = (ArrayList<PrivateCustomer>) privateRepo.findAll();
        ArrayList<CompanyCustomer> companies = (ArrayList<CompanyCustomer>) companyRepo.findAll();

        for (PrivateCustomer e : privates) {
            result.add(new CustomerShort(e.getIdPC(), 'P', e.getCustomerCode()));
        }
        for (CompanyCustomer e : companies) {
            result.add(new CustomerShort(e.getIdCC(), 'C', e.getCustomerCode()));
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
        if (privateRepo.count() == 0)
            throw new FileNotFoundException();
        PrivateCustomer result = privateRepo.findByIdPC(id);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public CompanyCustomer sellectCompanyCustomerByID(int id) throws Exception {
        if (companyRepo.count() == 0)
            throw new FileNotFoundException();
        CompanyCustomer result = companyRepo.findByIdCC(id);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public void updatePrivateCustomerByID(int id, String customerCode, String phoneNo, String name, String surname,
            String personCode, City city, String streetOrHouseTitle, int houseNo) throws Exception {

        PrivateCustomer customer = privateRepo.findByIdPC(id);
        if (customer == null)
            throw new FileNotFoundException();

        Person person = customer.getPerson();

        if (personRepo.findByPersonCode(personCode) != null) {
            PrivateCustomer host = privateRepo.findByPersonIdP(personRepo.findByPersonCode(personCode).getIdP());
            if (host != null) {
                if (host.getIdPC() != id) {
                    throw new InstantiationException();
                }

            }
            Person existingPerson = personRepo.findByPersonCode(personCode);
            if (existingPerson.getIdP() == person.getIdP()) {
                person.setName(name);
                person.setSurname(surname);
            } else {
                person = personRepo.findByPersonCode(personCode);
                person.setName(name);
                person.setSurname(surname);
            }
        } else {
            person.setName(name);
            person.setSurname(surname);
            person.setPersonCode(personCode);
        }

        customer.setPerson(person);
        customer.setCustomerCode(person.getIdP() + "_person_" + person.getPersonCode());
        customer.setPhoneNo(phoneNo);
        Address existingAddress = addressRepo.findByCityAndStreetHouseTitleAndHouseNo(city, streetOrHouseTitle,
                houseNo);
        if (existingAddress == null) {
            Address address = new Address(city, streetOrHouseTitle, houseNo);
            addressRepo.save(address);
            customer.setAddress(address);
        } else {
            customer.setAddress(existingAddress);
        }
        privateRepo.save(customer);

    }

    @Override
    public void updateCompanyCustomerByID(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCompanyCustomerByID'");
    }

}
