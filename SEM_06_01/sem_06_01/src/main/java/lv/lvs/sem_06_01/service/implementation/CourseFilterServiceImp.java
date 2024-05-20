package lv.lvs.sem_06_01.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.sem_06_01.model.Course;
import lv.lvs.sem_06_01.repo.ICourseRepo;
import lv.lvs.sem_06_01.repo.IProfesorRepo;
import lv.lvs.sem_06_01.repo.IStudentRepo;
import lv.lvs.sem_06_01.service.ICourseFilterService;

@Service
public class CourseFilterServiceImp implements ICourseFilterService {
    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IProfesorRepo profesorRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public ArrayList<Course> selectCoursesByElc(int elc) throws Exception {
        if (elc < 0 || elc > 20) throw new Exception("WRONG PARAMETERS");
        ArrayList<Course> result = courseRepo.findByElc(elc);
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        System.out.println(result);
        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception {
        if (id < 0) throw new Exception("WRONG PARAMETERS");
        if (!profesorRepo.existsByIdP(id)) throw new Exception("404:ENTRY NOT FOUND");
        ArrayList<Course> result = courseRepo.findByProfesors(profesorRepo.findByIdP(id));
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
        if (id < 0) throw new Exception("WRONG PARAMETERS");
        if (!studentRepo.existsById(id)) throw new Exception("404:ENTRY NOT FOUND");
        ArrayList<Course> result = courseRepo.findByGradesStudentIdS(id);
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

    @Override
    public ArrayList<Course> selectAllCourses() throws Exception {
        ArrayList<Course> result = (ArrayList<Course>) courseRepo.findAll();
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

    @Override
    public float calculateAVGGradeInCourse(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateAVGGradeInCourse'");
    }
}
