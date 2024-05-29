package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.customer.CompanyCustomer;

public interface ICompanyCustomerRepo extends CrudRepository<CompanyCustomer, Integer>{

    CompanyCustomer findByCustomerCode(String customerCode);

    CompanyCustomer findByIdCC(int id);

    CompanyCustomer findByRegNo(String regNo);

}
