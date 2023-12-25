package com.example.CarSaleApp1.repositories;

import com.example.CarSaleApp1.dto.Car;
import com.example.CarSaleApp1.services.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements ProjectRepository<Car> {
    private final List<Car> repo = new ArrayList<>();
    private final CarDB carDB;

    @Autowired
    public CarRepository(CarDB carDB) {
        this.carDB = carDB;
    }

    @Override
    public List<Car> retrieveAll() {//полный список машин
        return carDB.getAll();
    }

    @Override
    public void store(Car car) {//добавление машин в список
        carDB.save(car);
    }

    @Override
    @Transactional
    public void removeCarById(int carIdToRemove) {//удаление по айдишке, которая образуется по хэшкоду и из-за этого не может повторяться
        carDB.removeCarById(carIdToRemove);
    }

    @Override
    @Transactional
    public void removeCarByMan(String carManToRemove){
        carDB.deleteCarByManufacturer(carManToRemove);
    }

    @Override
    @Transactional
    public void removeCarByYear(String carYearToRemove) {
        carDB.removeCarByYear(carYearToRemove);
    }

    @Override
    @Transactional
    public void removeCarByModel(String carModelToRemove) {
        carDB.removeCarByModel(carModelToRemove);
    }

    @Override
    @Transactional
    public void removeCarByPrice(int carPriceToRemove) {
        carDB.removeCarByPrice(carPriceToRemove);
    }

    @Override
    public List<Car> searchCarByMan(String carManToSearch) {
        List<Car>result = new ArrayList<>();
        for(Car car:retrieveAll()){
            if(carManToSearch.equals(car.getManufacturer()))result.add(car);
        }
        return result;
    }

    @Override
    public List<Car> searchCarByYear(String carYearToSearch) {
        List<Car>res = new ArrayList<>();
        for(Car car:retrieveAll()){
            if(car.getYear().equals(carYearToSearch))res.add(car);
        }
        return res;
    }

    @Override
    public List<Car> searchCarByModel(String carModelToSearch) {
        List<Car>res = new ArrayList<>();
        for(Car car:retrieveAll()){
            if(car.getModel().equals(carModelToSearch))res.add(car);
        }
        return res;
    }

    @Override
    public List<Car> searchCarByPrice(int carPriceToSearch) {
        List<Car>res = new ArrayList<>();
        for(Car car:retrieveAll()){
            if(car.getPrice()==carPriceToSearch)res.add(car);
        }
        return res;
    }
}
