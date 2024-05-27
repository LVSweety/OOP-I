package lv.lvs.sem_06_01.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.lvs.sem_06_01.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

    ArrayList<Grade> findByStudentIdS(int id);

    @Query(nativeQuery = true, value = "SELECT AVG(GRVALUE) FROM GRADE_TABLE WHERE IDC=?1")
    float calculateAVGByCourseId(int id);

    ArrayList<Grade> findByStudentIdSAndGrvalueLessThan(int id, int i);

}
