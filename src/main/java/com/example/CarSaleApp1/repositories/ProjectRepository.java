package com.example.CarSaleApp1.repositories;

import com.example.CarSaleApp1.dto.Car;

import java.util.List;


public interface ProjectRepository<T>{//объявляем интерфес, который будет использован для класса машина
    List<T> retrieveAll();

    void store(T Car);

    void removeCarById(int carIdToRemove);

    void removeCarByMan(String carManToRemove);

    void removeCarByYear(String carYearToRemove);

    void removeCarByModel(String carModelToRemove);

    void removeCarByPrice(int carPriceToRemove);

    List<Car> searchCarByMan(String carManToSearch);

    List<T> searchCarByYear(String carYearToSearch);

    List<T> searchCarByModel(String carModelToSearch);

    List<T> searchCarByPrice(int carPriceToSearch);
}
