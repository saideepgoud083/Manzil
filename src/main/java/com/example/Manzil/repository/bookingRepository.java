package com.example.Manzil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;

@Repository
public interface bookingRepository extends JpaRepository  <Booking,Integer>{

}
