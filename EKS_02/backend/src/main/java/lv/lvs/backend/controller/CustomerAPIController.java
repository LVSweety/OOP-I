package lv.lvs.backend.controller;

import java.util.ArrayList;

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
import lv.lvs.backend.model.Customer;
import lv.lvs.backend.model.communicationsInterfaces.CustomerUpdate;
import lv.lvs.backend.model.communicationsInterfaces.CustomerInsert;
import lv.lvs.backend.service.ICustomerHandlerService;


@RestController
@RequestMapping("/api/customer")
@SuppressWarnings("rawtypes")
public class CustomerAPIController {

    @Autowired
    private ICustomerHandlerService customerService;

    @GetMapping("/show/all")
    ResponseEntity getAllCustomer() {
        try {
            return new ResponseEntity<>(customerService.sellectAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show")
    ResponseEntity getCustomerByID(@RequestParam("id") int id) {
        try {
            ArrayList<Customer> result = new ArrayList<Customer>();
            result.add(customerService.sellectById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/remove")
    ResponseEntity removeCustomerByID(@RequestParam("id") int id) {
        try {
            Customer result = customerService.sellectById(id);
            if (result == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(customerService.removeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    ResponseEntity postUpdateCCustomer(@Valid @RequestBody CustomerUpdate customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.updateCustomer(customer.getIdC(), customer.getName(), customer.getSurname());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddPCustomer(@Valid @RequestBody CustomerInsert customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.insertCustomer(customer.getName(), customer.getSurname());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }
}
