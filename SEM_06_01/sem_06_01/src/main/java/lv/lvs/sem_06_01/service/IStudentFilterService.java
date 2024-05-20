package lv.lvs.sem_06_01.service;

import java.util.ArrayList;

import lv.lvs.sem_06_01.model.Student;

public interface IStudentFilterService {

    public abstract ArrayList<Student> sellectAllStudents() throws Exception;
}
