package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

    Customer findByNameAndSurname(String name, String surname);
    
}
