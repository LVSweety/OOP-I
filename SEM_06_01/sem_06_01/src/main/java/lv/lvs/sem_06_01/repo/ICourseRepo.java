package lv.lvs.sem_06_01.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.sem_06_01.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

}
