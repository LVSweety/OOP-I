package lv.lvs.sem_06_01.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.sem_06_01.model.Student;
import lv.lvs.sem_06_01.repo.ICourseRepo;
import lv.lvs.sem_06_01.repo.IProfesorRepo;
import lv.lvs.sem_06_01.repo.IStudentRepo;
import lv.lvs.sem_06_01.service.IStudentFilterService;

@Service
public class StudentFilterServiceImp implements IStudentFilterService{

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IProfesorRepo profesorRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public ArrayList<Student> sellectAllStudents() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellectAllStudents'");
    }

}
