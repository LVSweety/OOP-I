package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.Car;
import lv.lvs.backend.model.Customer;
import lv.lvs.backend.model.MaintenanceProcedure;
import lv.lvs.backend.repo.ICarRepo;
import lv.lvs.backend.repo.ICustomerRepo;
import lv.lvs.backend.repo.IMaintenanceProcedureRepo;
import lv.lvs.backend.service.ICustomerHandlerService;

@Service
public class CustomerHandlerImp implements ICustomerHandlerService {

    @Autowired
    private ICustomerRepo customerRepo;
    @Autowired
    private ICarRepo carRepo;
    @Autowired
    private IMaintenanceProcedureRepo maintRepo;

    @Override
    public ArrayList<Customer> sellectAll() throws Exception {
        if (customerRepo.count() == 0)
            throw new FileNotFoundException();
        return (ArrayList<Customer>) customerRepo.findAll();
    }

    @Override
    public Customer sellectById(int id) throws Exception {
        if (id < 0 || customerRepo.count() == 0)
            throw new IOException();
        Customer result = customerRepo.findById(id).get();
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public Customer removeById(int id) throws Exception {
        if (id < 0 || customerRepo.count() == 0)
            throw new IOException();
        Customer result = customerRepo.findById(id).get();
        if (result == null)
            throw new FileNotFoundException();

        ArrayList<Car> cars = (ArrayList<Car>) carRepo.findByCustomerIdC(id);
        for (Car e : cars) {
            ArrayList<MaintenanceProcedure> maintenence = (ArrayList<MaintenanceProcedure>) maintRepo.findByCarIdCA(e.getIdCA());
            maintRepo.deleteAll(maintenence);
        }
        carRepo.deleteAll(cars);
        customerRepo.delete(result);
        return result;
    }

    @Override
    public Customer insertCustomer(String name, String surname) throws Exception {

        Customer customer = customerRepo.findByNameAndSurname(name, surname);
        if (customer == null) {
            customer = new Customer(name, surname);
            return customerRepo.save(customer);
        }
        throw new InstantiationException();
    }

    @Override
    public Customer updateCustomer(int id, String name, String surname) throws Exception {
        if (id < 0 || customerRepo.count() == 0)
            throw new IOException();
        Customer result = customerRepo.findById(id).get();
        if (result == null)
            throw new FileNotFoundException();
        result.setName(name);
        result.setSurname(surname);
        return customerRepo.save(result);
    }
}
