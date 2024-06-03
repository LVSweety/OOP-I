package lv.lvs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lv.lvs.backend.service.ICarHandlerService;

@RestController
@RequestMapping("/api/car")
@SuppressWarnings("rawtypes")
public class CarAPIController {

    @Autowired
    private ICarHandlerService carService;

    @GetMapping("/show/all")
    ResponseEntity getAllCar() {
        try {
            return new ResponseEntity<>(carService.sellectAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/latest")
    ResponseEntity getCarRecentThan(@RequestParam("year") int year) {
        try {
            return new ResponseEntity<>(carService.sellectLatest(year), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/manu")
    ResponseEntity getCarByManufacturer(@RequestParam("manu") String manu) {
        try {
            return new ResponseEntity<>(carService.sellectByManufacturer(manu), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
