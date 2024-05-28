package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.customer.PrivateCustomer;

public interface IPrivateCustomerRepo extends CrudRepository<PrivateCustomer, Integer> {

    PrivateCustomer findByCustomerCode(String customerCode);

    PrivateCustomer findByIdPC(int id);

	PrivateCustomer findByPersonIdP(int idP);

}
