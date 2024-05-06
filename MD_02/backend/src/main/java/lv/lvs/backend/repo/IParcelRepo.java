package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.parcel.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer> {

}
