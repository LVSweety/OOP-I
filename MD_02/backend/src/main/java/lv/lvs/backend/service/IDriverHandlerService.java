package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.communicationsInterfaces.DriverShort;
import lv.lvs.backend.model.driver.Driver;

public interface IDriverHandlerService {

    public abstract ArrayList<Driver> sellectAllDriver() throws Exception;

    public abstract ArrayList<DriverShort> sellectAllDriverShort() throws Exception;
    
    public abstract Driver sellectDriverByID(int id) throws Exception;

    public abstract void deleteDriverByID(int id) throws Exception;

    public abstract void insertNewDriver(String name, String surname, String personCode, String licenseNo, float experienceInYears) throws Exception;

    public abstract void updateDriverByID(int id, String name, String surname, String personCode, String licenseNo, float experienceInYears) throws Exception;
}