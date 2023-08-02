package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;


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
            model.addAttribute("cars", carService.getCars());
        } else {
            model.addAttribute("cars", carService.listCars(count));
        }
        return "cars";
    }

}
