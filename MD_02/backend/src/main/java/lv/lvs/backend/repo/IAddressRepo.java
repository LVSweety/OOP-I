package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.parcel.Address;
import lv.lvs.backend.model.parcel.City;

public interface IAddressRepo extends CrudRepository<Address, Integer> {

    Address findByCityAndStreetHouseTitleAndHouseNo(City city, String streetOrHouseTitle, int houseNo);

}