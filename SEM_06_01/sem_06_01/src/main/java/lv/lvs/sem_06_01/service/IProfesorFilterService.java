package lv.lvs.sem_06_01.service;

import java.util.ArrayList;

import lv.lvs.sem_06_01.model.Profesor;

public interface IProfesorFilterService {

    public abstract ArrayList<Profesor> sellectAllProfesors() throws Exception;
}
