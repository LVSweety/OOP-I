package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.communicationsInterfaces.DriverShort;
import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.person.Person;
import lv.lvs.backend.repo.IDriverRepo;
import lv.lvs.backend.repo.IParcelRepo;
import lv.lvs.backend.repo.IPersonRepo;
import lv.lvs.backend.service.IDriverHandlerService;

@Service
public class DriverHandlerImp implements IDriverHandlerService {

    @Autowired
    private IParcelRepo parcelRepo;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private IDriverRepo driverRepo;

    @Override
    public ArrayList<Driver> sellectAllDriver() throws Exception {
        if (driverRepo.count() == 0)
            throw new FileNotFoundException();
        return (ArrayList<Driver>) driverRepo.findAll();
    }

    @Override
    public ArrayList<DriverShort> sellectAllDriverShort() throws Exception {
        if (driverRepo.count() == 0)
            throw new FileNotFoundException();
        ArrayList<DriverShort> result = new ArrayList<DriverShort>();
        ArrayList<Driver> drivers = (ArrayList<Driver>) driverRepo.findAll();

        for (Driver e : drivers) {
            result.add(new DriverShort(e.getIdD(), e.getLicenseNo()));
        }
        return result;
    }

    @Override
    public Driver sellectDriverByID(int id) throws Exception {
        if (id < 0 || driverRepo.count() == 0)
            throw new IOException();
        Driver result = driverRepo.findByIdD(id);
        if (result == null)
            throw new FileNotFoundException();
        return result;
    }

    @Override
    public void deleteDriverByID(int id) throws Exception {
        if (id < 0)
            throw new IOException();
        Driver driver = driverRepo.findByIdD(id);
        if (driverRepo.count() == 0)
            throw new FileNotFoundException();
        ArrayList<Parcel> parcels = (ArrayList<Parcel>) parcelRepo.findByDriverIdD(id);
        parcelRepo.deleteAll(parcels);
        int idP = driver.getPerson().getIdP();
        driverRepo.delete(driver);
        personRepo.deleteById(idP);
    }

    @Override
    public void insertNewDriver(String name, String surname, String personCode, String licenseNo,
            float experienceInYears) throws Exception {
        Driver driver = driverRepo.findByLicenseNo(licenseNo);
        Person person = personRepo.findByPersonCode(personCode);
        if (driver == null) {
            if (person == null) {
                person = new Person(name, surname, personCode);
                personRepo.save(person);
                driver = new Driver(experienceInYears, licenseNo, person);
                driverRepo.save(driver);
                return;
            } else {
                driver = driverRepo.findByPersonIdP(person.getIdP());
                if (driver == null) {
                    driver = new Driver(experienceInYears, licenseNo, person);
                    driverRepo.save(driver);
                    return;
                }
                throw new InstantiationException();
            }
        }
        throw new InstantiationException();
    }

    @Override
    public void updateDriverByID(int id, String name, String surname, String personCode, String licenseNo,
            float experienceInYears) throws Exception {
        Driver driver = driverRepo.findByIdD(id);
        
        if (driver == null)
            throw new FileNotFoundException();
        if ((driverRepo.findByLicenseNo(licenseNo) != null && driverRepo.findByLicenseNo(licenseNo).getIdD() != id))
            throw new InstantiationException();
        if (driverRepo.findByPersonIdP(personRepo.findByPersonCode(personCode).getIdP()).getIdD() != id)
            throw new InstantiationException();

        Person person = driver.getPerson();

        person.setName(name);
        person.setSurname(surname);
        person.setPersonCode(personCode);
        personRepo.save(person);
        driver.setLicenseNo(licenseNo);
        driver.setExperienceInYears(experienceInYears);
        driverRepo.save(driver);
    }
}