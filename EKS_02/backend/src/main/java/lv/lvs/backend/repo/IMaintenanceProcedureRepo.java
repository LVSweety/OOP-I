package lv.lvs.backend.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.MaintenanceProcedure;

public interface IMaintenanceProcedureRepo extends CrudRepository<MaintenanceProcedure, Integer> {

	ArrayList<MaintenanceProcedure> findByMechanicIdM(int id);

    ArrayList<MaintenanceProcedure> findByStartDateTimeBetween(LocalDateTime withHour, LocalDateTime plusDays);

    ArrayList<MaintenanceProcedure> findByCarIdCA(int idCA);
    
}
