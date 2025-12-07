package com.example.Manzil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Manzil.entity.Customer;
@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {

	//Customer findByMobileNum(long mob);

	Customer findByMob(long mob);

	Customer findCustomerBYmb(long mob);

}
