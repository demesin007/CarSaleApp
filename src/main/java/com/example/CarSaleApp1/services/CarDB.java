package com.example.CarSaleApp1.services;

import com.example.CarSaleApp1.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDB extends JpaRepository<Car,Integer> {
    @Query(value = "SELECT * FROM cars",nativeQuery = true)
    List<Car> getAll();

    @Modifying
    @Query(value = "DELETE FROM cars WHERE id = :id",nativeQuery = true)
    void removeCarById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM cars WHERE manufacturer = :manufac",nativeQuery = true)
    int deleteCarByManufacturer(@Param("manufac") String manufacturer);

    @Modifying
    @Query(value = "DELETE FROM cars WHERE year = :year",nativeQuery = true)
    void removeCarByYear(@Param("year") String year);
    @Modifying
    @Query(value = "DELETE FROM cars WHERE model=:model",nativeQuery = true)
    void removeCarByModel(@Param("model") String model);
    @Modifying
    @Query(value = "DELETE FROM cars WHERE price = :price",nativeQuery = true)
    void removeCarByPrice(@Param("price") Integer price);
}
