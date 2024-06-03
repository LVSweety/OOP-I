package lv.lvs.backend.service.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lvs.backend.model.Car;
import lv.lvs.backend.model.MaintenanceProcedure;
import lv.lvs.backend.model.Mechanic;
import lv.lvs.backend.repo.ICarRepo;
import lv.lvs.backend.repo.IMaintenanceProcedureRepo;
import lv.lvs.backend.repo.IMechanicRepo;
import lv.lvs.backend.service.IMaintenanceProcedureService;

@Service
public class MaintenanceProcedureImp implements IMaintenanceProcedureService {

    @Autowired
    private IMaintenanceProcedureRepo maintRepo;

    @Autowired
    private ICarRepo carRepo;

    @Autowired
    private IMechanicRepo mechanicRepo;

    @Override
    public ArrayList<MaintenanceProcedure> sellectAll() throws Exception {
        if (maintRepo.count() == 0)
            throw new FileNotFoundException();
        return (ArrayList<MaintenanceProcedure>) maintRepo.findAll();
    }

    @Override
    public ArrayList<MaintenanceProcedure> sellectByMechanicId(int id) throws Exception {
        if (maintRepo.count() == 0 || id < 0)
            throw new FileNotFoundException();
        return (ArrayList<MaintenanceProcedure>) maintRepo.findByMechanicIdM(id);
    }

    @Override
    public ArrayList<MaintenanceProcedure> sellectToday() throws Exception {
        // if (maintRepo.count() == 0)
        // throw new IOException();
        // return maintRepo.findByStartDateTimeBetween(
        // LocalDateTime.now()
        // .withNano(0)
        // .withSecond(0)
        // .withMinute(0)
        // .withHour(0),
        // LocalDateTime.now()
        // .withNano(0)
        // .withSecond(0)
        // .withMinute(0)
        // .withHour(0)
        // .plusDays(1))
        // .size();
        return null;
    }

    @Override
    public MaintenanceProcedure insertMaintenanceProcedure(int idCA, int idM, LocalDateTime start) throws Exception {
        if (idCA < 0 || idM < 0)
            throw new IOException();
        Car car = carRepo.findById(idCA).get();
        Mechanic mechanic = mechanicRepo.findById(idM).get();
        if (car == null || mechanic == null)
            throw new FileNotFoundException();
        MaintenanceProcedure maintenence = new MaintenanceProcedure(start, car, mechanic);
        return maintRepo.save(maintenence);
    }

}
