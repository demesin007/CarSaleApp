package com.example.CarSaleApp1.services;

import com.example.CarSaleApp1.dto.Car;
import com.example.CarSaleApp1.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final ProjectRepository<Car> carRepo;//использование заранее созданного интерфейса для исполнения функицй как удаление, поиск и сохранение

    private final CarDB carDB;


    @Autowired
    public CarService(ProjectRepository<Car> carRepo, CarDB carDB) {
        this.carRepo = carRepo;
        this.carDB = carDB;
    }


    public List<Car> getAllCars(){
        return carRepo.retrieveAll();
    }

    public void saveCar(Car car){
        carRepo.store(car);
        carDB.save(car);
    }


    public void removeCarById(int carIdToRemove) {
        carRepo.removeCarById(carIdToRemove);
    }

    public void removeCarByMan(String carManToRemove) {
        carRepo.removeCarByMan(carManToRemove);
    }

    public void removeCarByYear(String carYearToRemove) {
        carRepo.removeCarByYear(carYearToRemove);
    }

    public void removeCarByModel(String carModelToRemove) {
        carRepo.removeCarByModel(carModelToRemove);
    }

    public void removeCarByPrice(int carPriceToRemove) {
        carRepo.removeCarByPrice(carPriceToRemove);
    }

    public List<Car> searchCarByMan(String carManToSearch) {
        return carRepo.searchCarByMan(carManToSearch);
    }

    public List<Car> searchCarByYear(String carYearToSearch) {
        return carRepo.searchCarByYear(carYearToSearch);
    }

    public List<Car> searchCarByModel(String carModelToSearch) {
        return carRepo.searchCarByModel(carModelToSearch);
    }

    public List<Car> searchCarByPrice(int carPriceToSearch) {
        return carRepo.searchCarByPrice(carPriceToSearch);
    }
}
