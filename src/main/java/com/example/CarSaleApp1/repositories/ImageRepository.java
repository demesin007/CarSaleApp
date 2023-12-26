package com.example.CarSaleApp1.repositories;

import com.example.CarSaleApp1.dto.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}