package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.driver.Driver;

public interface IDriverRepo extends CrudRepository<Driver, Integer>{

}
