package lv.lvs.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.lvs.backend.model.MaintenanceProcedure;

public interface IMaintenanceProcedureService {

    public abstract ArrayList<MaintenanceProcedure> sellectAll() throws Exception;

    public abstract ArrayList<MaintenanceProcedure> sellectByMechanicId(int id) throws Exception;

    public abstract ArrayList<MaintenanceProcedure> sellectToday() throws Exception;
    
    public abstract MaintenanceProcedure insertMaintenanceProcedure(int idCA, int idM, LocalDateTime start) throws Exception;
}
