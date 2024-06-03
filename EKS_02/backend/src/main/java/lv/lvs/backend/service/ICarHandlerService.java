package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.Car;

public interface ICarHandlerService {

    public abstract ArrayList<Car> sellectAll() throws Exception;

    public abstract ArrayList<Car> sellectLatest(int year) throws Exception;

    public abstract ArrayList<Car> sellectByManufacturer(String manufacturer) throws Exception;
}
