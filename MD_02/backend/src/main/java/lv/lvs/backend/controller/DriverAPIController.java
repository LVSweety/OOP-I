package lv.lvs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.lvs.backend.model.communicationsInterfaces.DriverCreate;
import lv.lvs.backend.model.communicationsInterfaces.DriverUpdate;
import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.service.IDriverHandlerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/driver")
public class DriverAPIController {

    @Autowired
    private IDriverHandlerService driverService;

    @GetMapping("/show/all")
    List<Driver> getAllDrivers(Model model) {
        try {
            return driverService.sellectAllDriver();
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }

    @GetMapping("/show")
    List<Driver> getDriverByID(@RequestParam("id") int id, Model model) {
        try {
            ArrayList<Driver> result = new ArrayList<Driver>();
            result.add(driverService.sellectDriverByID(id));
            return result;
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }

    @GetMapping("/remove")
    List<Driver> gatDriverByID(@RequestParam("id") int id, Model model) {
        try {
            Driver result = driverService.sellectDriverByID(id);
            if (result == null)
                return new ArrayList<Driver>();
            driverService.deleteDriverByID(id);
            return driverService.sellectAllDriver();
        } catch (Exception e) {
            return new ArrayList<Driver>();
        }
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    String postAddDriver(@Valid @RequestBody DriverCreate driver, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return "[{\"status\": 1}]";
            } else {
                driverService.insertNewDriver(driver.getName(), driver.getSurname(), driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
            }
            return "[{\"status\": 0}]";
        } catch (Exception e) {
            return "[{\"status\": 1}]";
        }
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    String postUpdateDriver(@Valid @RequestBody DriverUpdate driver, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return "[{\"status\": 1}]";
            } else {
                driverService.updateDriverByID(driver.getIdD(), driver.getName(), driver.getSurname(), driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
            }
            return "[{\"status\": 0}]";
        } catch (Exception e) {
            return "[{\"status\": 1}]";
        }
    }

}
