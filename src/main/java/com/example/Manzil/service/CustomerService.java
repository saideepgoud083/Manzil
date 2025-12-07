package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.service.Exception.CustomerAlreadyExistsException;
import com.example.Manzil.service.Exception.DataIntegrityViolationException;
import com.example.Manzil.service.Exception.DriverAlreadyExistsException;

@Service
public class CustomerService {
@Autowired
	private CustomerRepositry cr;
@Autowired
private LocationService ls;
@Autowired
CoordinateService cs;
	public responcestucture<Customer> registerCust(CustomerDto cd) {
		// TODO Auto-generated method stub
		  Customer c1 = cr.findByMob(cd.getMob());
		    if (c1 != null) {
		        throw new CustomerAlreadyExistsException();  // same as doctor already exists exception
		    }
		
		Customer c = new Customer();
       c.setName(cd.getName());
       c.setAge(cd.getAge());
       c.setGender(cd.getGender());
       c.setMob(cd.getMob());
       c.setEmailid(cd.getEmail());
       String loc = ls.getLocation(cd.getLatitude(),cd.getLongitude());
       c.setCurrentLocation(loc);
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
		 if (c != null) {
		        throw new DataIntegrityViolationException("Customer not found, cannot delete"); // same as doctor already exists exception
		    }
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
	    if (c != null) {
	        throw new DataIntegrityViolationException("Driver not found with Mob: " + mob); // same as doctor already exists exception
	    }
	    
	    rs.setStatuscode(HttpStatus.FOUND.value());
	    rs.setMasg("Customer found successfully");
	    rs.setData(c);

	    return rs;
	}



	public responcestucture<String> seaAllAvalVechiles(long mob, String destinationlocation) {
		
		double[] coords = cs.getCoordinates(destinationlocation);
		  responcestucture<String> rs = new responcestucture<>();
	   
	    if (coords == null) {
	      
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Invalid destination location");
	        rs.setData("No valid coordinates found for: " + destinationlocation);
	        return rs;
	    }
	    
	    
		
		Customer c=cr.findCustomerBYmb(mob);
	Booking b=new Booking();
	
	b.setSourcelocation(c.getCurrentLocation());
	b.setDestinationlocation(destinationlocation);
	
		
		
	}
	
	
	
	


}
