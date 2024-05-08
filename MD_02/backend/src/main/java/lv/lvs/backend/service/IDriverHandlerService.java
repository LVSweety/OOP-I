package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.driver.Driver;

public interface IDriverHandlerService {

    public abstract ArrayList<Driver> sellectAllDriver() throws Exception;
    
    public abstract Driver sellectDriverByID(int id) throws Exception;

    public abstract void deleteDriverByID(int id) throws Exception;

    public abstract void insertNewDriver(Driver driver) throws Exception;

    public abstract void updateDriverByID(int id, Driver driver) throws Exception;
}