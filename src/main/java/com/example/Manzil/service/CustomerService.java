package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.repository.CustomerRepositry;

@Service
public class CustomerService {
@Autowired
	private CustomerRepositry cr;
@Autowired
private LocationService ls;
	public void registerCust(CustomerDto cd) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
       c.setName(cd.getName());
       c.setAge(cd.getAge());
       c.setGender(cd.getGender());
       c.setMob(cd.getMob());
       c.setEmailid(cd.getEmail());
       String loc = ls.getLocation(cd.getLatitude(),cd.getLongitude());
       c.setCurrentLocation(loc);
       cr.save(c);

	
	}

}
