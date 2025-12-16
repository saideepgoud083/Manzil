package com.example.Manzil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Manzil.entity.Payment;
@Repository
public interface paymentrepository  extends JpaRepository<Payment,Integer>{

}
