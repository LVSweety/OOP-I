package lv.lvs.backend.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.parcel.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer> {

    ArrayList<Parcel> findByDriverIdD(int id);

}
