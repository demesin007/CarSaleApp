package com.example.CarSaleApp1.repositories;

import com.example.CarSaleApp1.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}