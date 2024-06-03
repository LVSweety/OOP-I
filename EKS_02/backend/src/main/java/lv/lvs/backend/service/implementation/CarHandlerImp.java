package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.Car;
import lv.lvs.backend.repo.ICarRepo;
import lv.lvs.backend.service.ICarHandlerService;

@Service
public class CarHandlerImp implements ICarHandlerService {

    @Autowired
    private ICarRepo carRepo;

    @Override
    public ArrayList<Car> sellectAll() throws Exception {
        if (carRepo.count() == 0)
            throw new FileNotFoundException();
        return (ArrayList<Car>) carRepo.findAll();
    }

    @Override
    public ArrayList<Car> sellectLatest(int year) throws Exception {
        if (carRepo.count() == 0 || year < 0)
            throw new FileNotFoundException();
        return carRepo.findByModelYearGreaterThan(year);
    }

    @Override
    public ArrayList<Car> sellectByManufacturer(String manufacturer) throws Exception {
        if (carRepo.count() == 0 || manufacturer == null)
            throw new FileNotFoundException();
        return carRepo.findByManufacturer(manufacturer);
    }

}
