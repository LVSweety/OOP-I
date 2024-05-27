package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.parcel.ParcelSize;
import lv.lvs.backend.repo.ICompanyCustomerRepo;
import lv.lvs.backend.repo.IDriverRepo;
import lv.lvs.backend.repo.IParcelRepo;
import lv.lvs.backend.repo.IPrivateCustomerRepo;
import lv.lvs.backend.service.IParcelHandlerService;

@Service
public class ParcelHandlerImp implements IParcelHandlerService {

    @Autowired
    private IParcelRepo parcelRepo;
 
    @Autowired
    private IPrivateCustomerRepo privateRepo;

    @Autowired
    private ICompanyCustomerRepo companyRepo;

    @Autowired
    private IDriverRepo driverRepo;

    @Override
    public ArrayList<Parcel> sellectAllParcel() throws Exception {
        if (parcelRepo.count() == 0)
            throw new FileNotFoundException();
        return (ArrayList<Parcel>) parcelRepo.findAll();
    }

    @Override
    public Parcel sellectParcelByID(int id) throws Exception {
        if (id < 0)
            throw new IOException();
        Parcel result = parcelRepo.findByIdPA(id);
        if (parcelRepo.count() == 0)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public void deleteParcelByID(int id) throws Exception {
        if (id < 0 || parcelRepo.count() == 0)
            throw new IOException();
        Parcel result = parcelRepo.findByIdPA(id);
        if (result == null)
            throw new FileNotFoundException();
        parcelRepo.delete(result);
    }

    @Override
    public ArrayList<Parcel> selectAllParcelByCustomerId(int idPC, int idCC) throws Exception {
        if ((idPC < 0 && idCC < 0) || parcelRepo.count() == 0)
            throw new IOException();
        ArrayList<Parcel> result = parcelRepo.findByCompanyCustomerIdCCOrPrivateCustomerIdPC(idCC, idPC);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public ArrayList<Parcel> selectAllParcelDeliveredByDriverId(int id) throws Exception {
        if (id < 0 || parcelRepo.count() == 0)
            throw new IOException();
        ArrayList<Parcel> result = parcelRepo.findByDriverIdD(id);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public ArrayList<Parcel> selectAllParcelPriceRange(float min, float max) throws Exception {
        if (max < min || min < 0 || max < 0)
            throw new IOException();
        ArrayList<Parcel> result = parcelRepo.findByPriceBetween(min, max);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public ArrayList<Parcel> selectAllParcelDeliveredToCity(City city) throws Exception {
        // System.out.println(city.ordinal());
        ArrayList<Parcel> result = parcelRepo.findByCity(city.ordinal());
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public float calculateIncomeOfParcelsByCustomerId(int idPC, int idCC) throws Exception {
        if ((idPC < 0 && idCC < 0) || parcelRepo.count() == 0)
            throw new IOException();
        return parcelRepo.getIncome(idPC, idCC);
    }

    @Override
    public int calculateHowManyParcelsNeedToDeliverToday() throws Exception {
        if (parcelRepo.count() == 0)
            throw new IOException();
        return parcelRepo.findByPlannedDeliveryBetween(
                LocalDateTime.now()
                        .withNano(0)
                        .withSecond(0)
                        .withMinute(0)
                        .withHour(0),
                LocalDateTime.now()
                        .withNano(0)
                        .withSecond(0)
                        .withMinute(0)
                        .withHour(0)
                        .plusDays(1))
                .size();
    }

    @Override
    public void updateParcelByID(int id, LocalDateTime orderCreated, LocalDateTime plannedDelivery, float price, ParcelSize size, boolean fragile, String customerCode, int idD) throws Exception {
        if (parcelRepo.count() == 0)
            throw new IOException();
        if (customerCode.matches("[0-9]+_company_LV[0-9]{11}")) {
            Parcel parcel = parcelRepo.findByIdPA(id);
            CompanyCustomer customer = companyRepo.findByCustomerCode(customerCode);
            Driver driver = driverRepo.findByIdD(idD);
            if (driver == null || customer == null) 
                throw new IOException();    
            parcel.setCompanyCustomer(customer);
            parcel.setPrivateCustomer(null);
            parcel.setDriver(driver);

            parcel.setOrderCreated(orderCreated);
            parcel.setPlannedDelivery(plannedDelivery);
            parcel.setPrice(price);
            parcel.setSize(size);
            parcel.setFragile(fragile);

            parcelRepo.save(parcel);
        } else if (customerCode.matches("[0-9]+_person_[0-9]{6}-[0-9]{5}")) {
            Parcel parcel = parcelRepo.findByIdPA(id);
            PrivateCustomer customer = privateRepo.findByCustomerCode(customerCode);
            Driver driver = driverRepo.findByIdD(idD);
            if (driver == null || customer == null) 
                throw new IOException();    
            parcel.setCompanyCustomer(null);
            parcel.setPrivateCustomer(customer);
            parcel.setDriver(driver);

            parcel.setOrderCreated(orderCreated);
            parcel.setPlannedDelivery(plannedDelivery);
            parcel.setPrice(price);
            parcel.setSize(size);
            parcel.setFragile(fragile);
            parcel.setOrderCreated(orderCreated);
            parcel.setPlannedDelivery(plannedDelivery);
            parcel.setPrice(price);
            parcel.setSize(size);
            parcel.setFragile(fragile);

            parcelRepo.save(parcel);
        }
        


    }
}
