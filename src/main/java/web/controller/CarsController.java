package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImp carService;
    @Autowired
    public CarsController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count==null) {
            model.addAttribute("cars", carService.listCars(CarServiceImp.getCarsCount()));
        } else {
            model.addAttribute("cars", carService.listCars(count));
        }
        return "cars";
    }

}
