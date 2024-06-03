package lv.lvs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.lvs.backend.model.communicationsInterfaces.MaintInsert;
import lv.lvs.backend.service.IMaintenanceProcedureService;


@RestController
@RequestMapping("/api/maint")
@SuppressWarnings("rawtypes")
public class MaintAPIController {

    @Autowired
    private IMaintenanceProcedureService maintService;

    @GetMapping("/show/all")
    ResponseEntity getAllCar() {
        try {
            return new ResponseEntity<>(maintService.sellectAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/mechanic")
    ResponseEntity getDriverByID(@RequestParam("id") int id) {
        try {
            return new ResponseEntity<>(maintService.sellectByMechanicId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/today")
    ResponseEntity getDriverByID() {
        try {
            return new ResponseEntity<>(maintService.sellectToday(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddPCustomer(@Valid @RequestBody MaintInsert maint, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                maintService.insertMaintenanceProcedure(maint.getIdCA(), maint.getIdM(), maint.getStartDateTime());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }
}
