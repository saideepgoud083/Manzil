package com.example.Manzil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findByLicenseNum(String licenseNum);

    Driver findByMobileNum(long mobile);
}
