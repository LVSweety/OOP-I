package lv.lvs.backend.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.Car;

public interface ICarRepo extends CrudRepository<Car, Integer> {

    ArrayList<Car> findByModelYearGreaterThan(int year);

    ArrayList<Car> findByManufacturer(String manufacturer);

    ArrayList<Car> findByCustomerIdC(int id);
    
}
