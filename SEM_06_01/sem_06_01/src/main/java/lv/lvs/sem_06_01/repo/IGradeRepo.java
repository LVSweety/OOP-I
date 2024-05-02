package lv.lvs.sem_06_01.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.sem_06_01.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

}
