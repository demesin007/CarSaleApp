package com.example.CarSaleApp1.controllers;

import com.example.CarSaleApp1.dto.Car;
import com.example.CarSaleApp1.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/car")//обозначение стартового поля в url
public class MainPageController {
    private CarService carService;

    @Autowired
    public MainPageController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/main")//логика страницы localhost:8082/car/main
    public String home(Model model){//модель используется для передачи данных с клиента на сервер и наоборот
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        return "index";
    }

    @PostMapping("/save")
    public String saveCar(Car car, Model model){
        carService.saveCar(car);
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        return "redirect:/car/main";
    }

    @PostMapping("/remove")
    public String removeCar(@RequestParam(value = "carIdToRemove") int carIdToRemove) {
        carService.removeCarById(carIdToRemove);
        return "redirect:/car/main";
    }

    @PostMapping("/removeMan")
    public String removeMan(@RequestParam(value = "carManToRemove") String carManToRemove) {
        carService.removeCarByMan(carManToRemove);
        return "redirect:/car/main";
    }

    @PostMapping("/removeYear")
    public String removeYear(@RequestParam(value = "carYearToRemove") String carYearToRemove) {
        carService.removeCarByYear(carYearToRemove);
        return "redirect:/car/main";
    }

    @PostMapping("/removeModel")
    public String removeModel(@RequestParam(value = "carModelToRemove") String carModelToRemove) {
        carService.removeCarByModel(carModelToRemove);
        return "redirect:/car/main";
    }


    @PostMapping("/removePrice")
    public String removePrice(@RequestParam(value = "carPriceToRemove") int carPriceToRemove) {
        carService.removeCarByPrice(carPriceToRemove);
        return "redirect:/car/main";
    }

}
