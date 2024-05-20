package lv.lvs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.service.IParcelHandlerService;

@RestController
@RequestMapping("/api/parcel")
public class ParcelAPIController {
    @Autowired
    private IParcelHandlerService parcelService;

    @GetMapping("/show/all")
    List<Parcel> getAllParcels(Model model) {
        try {
            return parcelService.sellectAllParcel();
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    @GetMapping("/show")
    List<Parcel> getParcelByID(@RequestParam("id") int id, Model model) {
        try {
            ArrayList<Parcel> result = new ArrayList<Parcel>();
            result.add(parcelService.sellectParcelByID(id));
            return result;
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    @GetMapping("/remove")
    List<Parcel> removeParcelByID(@RequestParam("id") int id, Model model) {
        try {
            Parcel result = parcelService.sellectParcelByID(id);
            if (result == null)
                return new ArrayList<Parcel>();
            parcelService.deleteParcelByID(id);
            return parcelService.sellectAllParcel();
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    // http://127.0.0.1:8080/api/parcel/show/customer?type=a&id=1
    @GetMapping("/show/customer")
    List<Parcel> getParcelByCustomerID(@RequestParam("type") char type, @RequestParam("id") int id, Model model) {
        try {
            switch (type) {
                case 'P':
                    return parcelService.selectAllParcelByCustomerId(id, 0);
                case 'C':
                    return parcelService.selectAllParcelByCustomerId(0, id);
                default:
                    return new ArrayList<Parcel>();
            }
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    @GetMapping("/show/income")
    float getIncomeByCustomerID(@RequestParam("type") char type, @RequestParam("id") int id, Model model) {
        try {
            switch (type) {
                case 'P':
                    return parcelService.calculateIncomeOfParcelsByCustomerId(id, 0);
                case 'C':
                    return parcelService.calculateIncomeOfParcelsByCustomerId(0, id);
                default:
                    break;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    @GetMapping("/show/driver")
    List<Parcel> getParcelByDriverID(@RequestParam("id") int id, Model model) {
        try {
            return parcelService.selectAllParcelDeliveredByDriverId(id);
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    @GetMapping("/show/price")
    List<Parcel> getParcelByPriceRange(@RequestParam("min") int min, @RequestParam("max") int max, Model model) {
        try {
            return parcelService.selectAllParcelPriceRange(min, max);
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }

    @GetMapping("/show/city")
    List<Parcel> getParcelByCity(@RequestParam("city") City city, Model model) {
        try {
            return parcelService.selectAllParcelDeliveredToCity(city);
        } catch (Exception e) {
            return new ArrayList<Parcel>();
        }
    }
}
