package lv.lvs.sem_06_01.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.sem_06_01.model.Profesor;
import lv.lvs.sem_06_01.repo.ICourseRepo;
import lv.lvs.sem_06_01.repo.IProfesorRepo;
import lv.lvs.sem_06_01.repo.IStudentRepo;
import lv.lvs.sem_06_01.service.IProfesorFilterService;

@Service
public class ProfesorFilterServiceImp implements IProfesorFilterService {

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IProfesorRepo profesorRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public ArrayList<Profesor> sellectAllProfesors() throws Exception {
        ArrayList<Profesor> result = (ArrayList<Profesor>) profesorRepo.findAll();
        if (result.isEmpty()) throw new Exception("404:NO DATA FOUND");
        return result;
    }

}
