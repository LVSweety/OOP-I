package lv.lvs.sem_06_01.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.sem_06_01.model.Course;
import lv.lvs.sem_06_01.model.Grade;
import lv.lvs.sem_06_01.model.Profesor;
import lv.lvs.sem_06_01.repo.ICourseRepo;
import lv.lvs.sem_06_01.repo.IGradeRepo;
import lv.lvs.sem_06_01.repo.IProfesorRepo;
import lv.lvs.sem_06_01.repo.IStudentRepo;
import lv.lvs.sem_06_01.service.IGradeFilterService;

@Service
public class GradeFilterServiceImp implements IGradeFilterService {

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IProfesorRepo profesorRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IGradeRepo gradeRepo;

    @Override
    public ArrayList<Grade> selectAllGrades() throws Exception {
        ArrayList<Grade> result = (ArrayList<Grade>) gradeRepo.findAll();
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

    @Override
    public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
        if (id < 0) throw new Exception("WRONG PARAMETERS");
        if (!studentRepo.existsById(id)) throw new Exception("404:ENTRY NOT FOUND");
        ArrayList<Grade> result = gradeRepo.findByStudentIdS(id);
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

    @Override
    public ArrayList<Grade> selectFailedGradesByStudentId(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectFailedGradesByStudentId'");
    }

    @Override
    public float calculateAVGGradeInCourseById(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateAVGGradeInCourseById'");
    }

}
