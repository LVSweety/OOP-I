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
import lv.lvs.backend.model.communicationsInterfaces.CustomerShort;
import lv.lvs.backend.model.communicationsInterfaces.DriverCreate;
import lv.lvs.backend.model.communicationsInterfaces.DriverUpdate;
import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.service.ICustomerHandlerService;
import lv.lvs.backend.service.IDriverHandlerService;
import lv.lvs.backend.service.IParcelHandlerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPIController {

    @Autowired
    private ICustomerHandlerService customerService;

    @GetMapping("/show/all")
    List<CustomerShort> getAllDrivers(Model model) {
        try {
            return customerService.sellectAllCustomer();
        } catch (Exception e) {
            return new ArrayList<CustomerShort>();
        }
    }
}
