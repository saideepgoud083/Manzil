package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.service.Exception.DataIntegrityViolationException;

@Service
public class CustomerService {
@Autowired
	private CustomerRepositry cr;
@Autowired
private LocationService ls;
	public responcestucture<Customer> registerCust(CustomerDto cd) {
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

       
             
       

     Customer save=  cr.save(c);
       responcestucture<Customer> rs = new responcestucture<>();
       rs.setStatuscode(HttpStatus.CREATED.value());
	    rs.setMasg("Customer registered successfully");
	    rs.setData(save);
return rs;

	
	}
	public responcestucture<Customer> deleteCustMob(long mob) {
		// TODO Auto-generated method stub
		Customer c=cr.findByMob(mob);
		cr.delete(c);
		responcestucture<Customer> rs = new responcestucture<>();
		   rs.setStatuscode(HttpStatus.OK.value() );
		    rs.setMasg("Customer deleted successfully");
		    rs.setData(c);
		    return rs;
	}
	public responcestucture<Customer> findCust(long mob) {
		// TODO Auto-generated method stub
		responcestucture<Customer> rs = new responcestucture<>();

	    Customer c = cr.findByMob(mob);
	                 
	    
	    rs.setStatuscode(HttpStatus.FOUND.value());
	    rs.setMasg("Customer found successfully");
	    rs.setData(c);

	    return rs;
	}
	
	
	
	
	
	
	
	
	


}
