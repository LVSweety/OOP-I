package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.repo.IDriverRepo;
import lv.lvs.backend.repo.IParcelRepo;
import lv.lvs.backend.repo.IPersonRepo;
import lv.lvs.backend.service.IDriverHandlerService;

@Service
public class DriverHandlerImp implements IDriverHandlerService{

    @Autowired
    private IParcelRepo parcelRepo;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private IDriverRepo driverRepo;

    @Override
    public ArrayList<Driver> sellectAllDriver() throws Exception {
        if ( driverRepo.count() == 0 ) throw new FileNotFoundException();
        return (ArrayList<Driver>) driverRepo.findAll();
    }

    @Override
    public Driver sellectDriverByID(int id) throws Exception {
        if (id < 0) throw new IOException();
        Driver result = driverRepo.findByIdD(id);
        if ( driverRepo.count() == 0 ) throw new FileNotFoundException();
        return result;
    } 

    @Override
    public void deleteDriverByID(int id) throws Exception {
        if (id < 0) throw new IOException();
        Driver driver = driverRepo.findByIdD(id);
        if ( driverRepo.count() == 0 ) throw new FileNotFoundException();
        ArrayList<Parcel> parcels = (ArrayList<Parcel>) parcelRepo.findByDriverIdD(id);
        parcelRepo.deleteAll(parcels);
        int idP = driver.getPerson().getIdP();
        driverRepo.delete(driver);
        personRepo.deleteById(idP);
    }

    @Override
    public void insertNewDriver(Driver driver) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertNewDriver'");
    }

    @Override
    public void updateDriverByID(int id, Driver driver) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDriverByID'");
    }

}
