package lv.lvs.sem_06_01.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.sem_06_01.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

    ArrayList<Course> findByElc(int ecl);

    ArrayList<Course> findByGradesStudentIdS(int id);

    ArrayList<Course> findByProfesorIdP(int id);

}
