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
import lv.lvs.backend.model.communicationsInterfaces.CCustomerCreate;
import lv.lvs.backend.model.communicationsInterfaces.CCustomerUpdate;
import lv.lvs.backend.model.communicationsInterfaces.PCustomerCreate;
import lv.lvs.backend.model.communicationsInterfaces.PCustomerUpdate;
import lv.lvs.backend.service.ICustomerHandlerService;


@RestController
@RequestMapping("/api/customer")
@SuppressWarnings("rawtypes")
public class CustomerAPIController {

    @Autowired
    private ICustomerHandlerService customerService;

    @GetMapping("/show/all")
    ResponseEntity getAllDrivers(Model model) {
        try {
            return new ResponseEntity<>(customerService.sellectAllCustomer(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show")
    ResponseEntity getCustomerByCustomer(@RequestParam("type") char type, @RequestParam("id") int id, Model model) {
        try {
            switch (type) {
                case 'P':
                    return new ResponseEntity<>(customerService.sellectPrivateCustomerByID(id), HttpStatus.OK);
                case 'C':
                    return new ResponseEntity<>(customerService.sellectCompanyCustomerByID(id), HttpStatus.OK);
                default:
                    break;
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update/p", consumes = "application/json", produces = "application/json")
    ResponseEntity postUpdatePCustomer(@Valid @RequestBody PCustomerUpdate customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.updatePrivateCustomerByID(customer.getId(), customer.getCustomerCode(), customer.getPhoneNo(), customer.getName(), customer.getSurname(), customer.getPersonCode(), customer.getCity(), customer.getStreetHouseTitle(), customer.getHouseNo());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update/c", consumes = "application/json", produces = "application/json")
    ResponseEntity postUpdateCCustomer(@Valid @RequestBody CCustomerUpdate customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.updateCompanyCustomerByID(customer.getId(), customer.getCustomerCode(), customer.getPhoneNo(), customer.getRegNo(), customer.getTitle(), customer.getCity(), customer.getStreetHouseTitle(), customer.getHouseNo());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add/p", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddPCustomer(@Valid @RequestBody PCustomerCreate customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.insertPrivateCustomerByID(customer.getPhoneNo(), customer.getName(), customer.getSurname(), customer.getPersonCode(), customer.getCity(), customer.getStreetHouseTitle(), customer.getHouseNo());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add/c", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddCCustomer(@Valid @RequestBody CCustomerCreate customer, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                customerService.insertCompanyCustomerByID(customer.getPhoneNo(), customer.getRegNo(), customer.getTitle(), customer.getCity(), customer.getStreetHouseTitle(), customer.getHouseNo());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }
}
