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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class SearchController {
    private CarService carService;
    private List<Car>SearchResult = new ArrayList<>();

    @Autowired
    public SearchController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/search")
    public String removePage(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        model.addAttribute("searchList",SearchResult);
        return "search";
    }

    @PostMapping("/searchMan")//логика поиска по manufacturer
    public String searchMan(@RequestParam(value = "carManToSearch") String carManToSearch, Model model) {
        this.SearchResult=carService.searchCarByMan(carManToSearch);
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        model.addAttribute("searchList",SearchResult);
        return "redirect:/car/search";
    }

    @PostMapping("/searchYear")
    public String searchYear(@RequestParam(value = "carYearToSearch") String carYearToSearch, Model model) {
        this.SearchResult=carService.searchCarByYear(carYearToSearch);
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        model.addAttribute("searchList",SearchResult);
        return "redirect:/car/search";
    }

    @PostMapping("/searchModel")
    public String searchModel(@RequestParam(value = "carModelToSearch") String carModelToSearch, Model model) {
        this.SearchResult=carService.searchCarByModel(carModelToSearch);
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        model.addAttribute("searchList",SearchResult);
        return "redirect:/car/search";
    }

    @PostMapping("/searchPrice")
    public String searchPrice(@RequestParam(value = "carPriceToSearch") int carPriceToSearch, Model model) {
        this.SearchResult=carService.searchCarByPrice(carPriceToSearch);
        model.addAttribute("car", new Car());
        model.addAttribute("carList",carService.getAllCars());
        model.addAttribute("searchList",SearchResult);
        return "redirect:/car/search";
    }
}
