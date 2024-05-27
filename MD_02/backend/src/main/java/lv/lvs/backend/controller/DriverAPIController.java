package lv.lvs.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@SuppressWarnings("rawtypes")
public class DriverAPIController {

    @Autowired
    private IDriverHandlerService driverService;

    
    @GetMapping("/show/all")
    ResponseEntity getAllDrivers(Model model) {
        try {
            return new ResponseEntity<>(driverService.sellectAllDriver(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/short")
    ResponseEntity getAllDriverShort(Model model) {
        try {
            return new ResponseEntity<>(driverService.sellectAllDriverShort(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/bind")
    ResponseEntity getAllDriversBindings(Model model) {
        try {
            return new ResponseEntity<>(driverService.sellectAllDriver(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show")
    ResponseEntity getDriverByID(@RequestParam("id") int id, Model model) {
        try {
            ArrayList<Driver> result = new ArrayList<Driver>();
            result.add(driverService.sellectDriverByID(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/remove")
    ResponseEntity removeDriverByID(@RequestParam("id") int id, Model model) {
        try {
            Driver result = driverService.sellectDriverByID(id);
            if (result == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            driverService.deleteDriverByID(id);
            return new ResponseEntity<>(driverService.sellectAllDriver(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddDriver(@Valid @RequestBody DriverCreate driver, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                driverService.insertNewDriver(driver.getName(), driver.getSurname(), driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    ResponseEntity postUpdateDriver(@Valid @RequestBody DriverUpdate driver, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                driverService.updateDriverByID(driver.getIdD(), driver.getName(), driver.getSurname(), driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

}