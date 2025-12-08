package com.example.Manzil.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Manzil.entity.Vehicle;
@Repository
public interface VechileRepositry extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByCurrentCity(String currentCity);

}
