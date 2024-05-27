package lv.lvs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lv.lvs.backend.model.communicationsInterfaces.CustomerShort;
import lv.lvs.backend.service.ICustomerHandlerService;


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
