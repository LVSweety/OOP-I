package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.parcel.Address;

public interface IAddressRepo extends CrudRepository<Address, Integer> {

}