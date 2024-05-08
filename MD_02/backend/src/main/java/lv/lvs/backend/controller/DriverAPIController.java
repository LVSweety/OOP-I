package lv.lvs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.service.IDriverHandlerService;

@RestController
@RequestMapping("/api/driver")
public class DriverAPIController {

    @Autowired
    private IDriverHandlerService driverService;

    @GetMapping("/show/all")
    List<Driver> getAllDrivers(Model model){
        try {
            return driverService.sellectAllDriver();
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }

    @GetMapping("/show")
    List<Driver> getDriverByID(@RequestParam("id") int id, Model model){
        try {
            ArrayList<Driver> result = new ArrayList<Driver>();
            result.add(driverService.sellectDriverByID(id));
            return result;
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }

    @GetMapping("/remove")
    List<Driver> gatDriverByID(@RequestParam("id") int id, Model model){
        try {
            Driver result = driverService.sellectDriverByID(id);
            if (result == null) return new ArrayList<Driver>();
            driverService.deleteDriverByID(id);
            return driverService.sellectAllDriver();
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }
}
