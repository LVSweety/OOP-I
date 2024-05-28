package lv.lvs.backend.controller;

import java.util.ArrayList;

import org.springframework.aop.AopInvocationException;
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
import lv.lvs.backend.model.communicationsInterfaces.ParcelCreate;
import lv.lvs.backend.model.communicationsInterfaces.ParcelUpdate;
import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.service.IParcelHandlerService;

@RestController
@RequestMapping("/api/parcel")
@SuppressWarnings("rawtypes")
public class ParcelAPIController {
    @Autowired
    private IParcelHandlerService parcelService;

    @GetMapping("/show/all")
    ResponseEntity getAllParcels(Model model) {
        try {
            return new ResponseEntity<>(parcelService.sellectAllParcel(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show")
    ResponseEntity getParcelByID(@RequestParam("id") int id, Model model) {
        try {
            ArrayList<Parcel> result = new ArrayList<Parcel>();
            result.add(parcelService.sellectParcelByID(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/remove")
    ResponseEntity removeParcelByID(@RequestParam("id") int id, Model model) {
        try {
            Parcel result = parcelService.sellectParcelByID(id);
            if (result == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            parcelService.deleteParcelByID(id);
            return new ResponseEntity<>(parcelService.sellectAllParcel(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/customer")
    ResponseEntity getParcelByCustomerID(@RequestParam("type") char type, @RequestParam("id") int id, Model model) {
        try {
            switch (type) {
                case 'P':
                    return new ResponseEntity<>(parcelService.selectAllParcelByCustomerId(id, 0), HttpStatus.OK);
                case 'C':
                    return new ResponseEntity<>(parcelService.selectAllParcelByCustomerId(0, id), HttpStatus.OK);
                default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/income")
    ResponseEntity getIncomeByCustomerID(@RequestParam("type") char type, @RequestParam("id") int id, Model model) {
        try {
            switch (type) {
                case 'P':
                    return new ResponseEntity<>(parcelService.calculateIncomeOfParcelsByCustomerId(id, 0), HttpStatus.OK);
                case 'C':
                    return new ResponseEntity<>(parcelService.calculateIncomeOfParcelsByCustomerId(0, id), HttpStatus.OK);
                default:
                    break;
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (AopInvocationException e) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/driver")
    ResponseEntity getParcelByDriverID(@RequestParam("id") int id, Model model) {
        try {
            return new ResponseEntity<>(parcelService.selectAllParcelDeliveredByDriverId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/price")
    ResponseEntity getParcelByPriceRange(@RequestParam("min") int min, @RequestParam("max") int max, Model model) {
        try {
            return new ResponseEntity<>(parcelService.selectAllParcelPriceRange(min, max), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/city")
    ResponseEntity getParcelByCity(@RequestParam("city") City city, Model model) {
        try {
            return new ResponseEntity<>(parcelService.selectAllParcelDeliveredToCity(city), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/today")
    ResponseEntity getParcelByToday(Model model) {
        try {
            return new ResponseEntity<>(parcelService.calculateHowManyParcelsNeedToDeliverToday(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    ResponseEntity postUpdateParcel(@Valid @RequestBody ParcelUpdate parcel, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                parcelService.updateParcelByID(parcel.getIdPA(), parcel.getOrderCreated(), parcel.getPlannedDelivery(),
                        parcel.getPrice(), parcel.getSize(), parcel.isFragile(), parcel.getCustomerCode(),
                        parcel.getIdD());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    ResponseEntity postAddParcel(@Valid @RequestBody ParcelCreate parcel, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
            } else {
                parcelService.insertNewParcel(parcel.getPlannedDelivery(), parcel.getSize(), parcel.isFragile(), parcel.getCustomerCode(), parcel.getIdD());
            }
            return new ResponseEntity<>("[{\"status\": 0}]", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[{\"status\": 1}]", HttpStatus.BAD_REQUEST);
        }
    }
}
