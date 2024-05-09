package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.person.Person;

public interface IPersonRepo extends CrudRepository<Person, Integer> {

    Person findByPersonCode(String personCode);

}
