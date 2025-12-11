package com.example.Manzil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.AvailabeVechileDto;
import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.entity.VechileDetails;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.repository.VechileRepositry;
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
private VechileRepositry vr;

@Autowired
CoordinateService cs;

@Autowired
CalculateDistanceService cds;

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
       String loc = ls.getCity(cd.getLatitude(),cd.getLongitude());
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




	public responcestucture<AvailabeVechileDto> seaAllAvalVechiles(long mob, String destinationlocation) {

	    responcestucture<AvailabeVechileDto> rs = new responcestucture<>();

	    // 1️⃣ Destination Coordinates
	    double[] destCoords = cs.getCoordinates(destinationlocation);
	    if (destCoords == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Invalid destination location: " + destinationlocation);
	        rs.setData(null);
	        return rs;
	    }

	    // 2️⃣ Customer
	    Customer c = cr.findByMob(mob);
	    if (c == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Customer not found");
	        rs.setData(null);
	        return rs;
	    }

	    String sourceCity = c.getCurrentLocation(); // Only city stored

	    // 3️⃣ Convert source city to coordinates
	    double[] srcCoords = cs.getCoordinates(sourceCity);
	    if (srcCoords == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Invalid source location: " + sourceCity);
	        rs.setData(null);
	        return rs;
	    }

	    // 4️⃣ Extract Lat & Long
	    double sourceLat   = srcCoords[0];
	    double sourceLon   = srcCoords[1];
	    double destLat     = destCoords[0];
	    double destLon     = destCoords[1];

	    // 5️⃣ Calculate Distance
	    double distance = cds.calculateDistance(sourceLat, sourceLon, destLat, destLon);

	    // 6️⃣ Prepare DTO
	    AvailabeVechileDto avd = new AvailabeVechileDto();
	    avd.setC(c);
	    avd.setDistance(distance);
	    avd.setSourceLocation(sourceCity);
	    avd.setDestinationLocation(destinationlocation);

	    // 7️⃣ Get Available Vehicles in Same City
	    List<Vehicle> vlist = vr.findByCurrentCityIgnoreCase(sourceCity);

	    for (Vehicle x : vlist) {

	        double fare = distance * x.getPricePerKm();


	        double avgSpeed = x.getAverageSpeed(); 


	        double time = distance / avgSpeed;

	        VechileDetails vd = new VechileDetails();
	        vd.setFare(fare);
	        vd.setEstimatedtimerequired(String.format("%.2f hr", time));
	        vd.setV(x);

	        avd.getAvailablevechicle().add(vd);
	    }

	    // 8️⃣ Final Response
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Available vehicles fetched successfully");
	    rs.setData(avd);
	    return rs;
	}


}
