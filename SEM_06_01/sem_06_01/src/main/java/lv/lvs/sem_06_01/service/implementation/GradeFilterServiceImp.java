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
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studentRepo.existsById(id)) throw new Exception("Student with id (" + id + ") doesn't exist");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIdS(id);
		
		if(result.isEmpty()) throw new Exception("There is no linkage between this student and grades");		
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectFailedGradesByStudentId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studentRepo.existsById(id)) throw new Exception("Student with id (" + id + ") doesn't exist");

		ArrayList<Grade> result = gradeRepo.findByStudentIdSAndGrvalueLessThan(id, 4);
		
		if(result.isEmpty()) throw new Exception("There is no failed grade for this student");		
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseById(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!courseRepo.existsById(id)) throw new Exception("Course with id (" + id + ") doesn't exist");
		
		float result = gradeRepo.calculateAVGByCourseId(id);
		
		if(result==0) throw new Exception("There is no linkage between this course and grades") ;
		
		return result;
	}

}
