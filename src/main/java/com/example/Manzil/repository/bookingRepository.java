package com.example.Manzil.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;

@Repository
public interface bookingRepository extends JpaRepository  <Booking,Integer>{

	



	List<Booking> findByDriver_DriverIdAndDatebooked(
	        int driverId,
	        String today
	);

	
}
