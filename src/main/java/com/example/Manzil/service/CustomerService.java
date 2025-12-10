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



//	public responcestucture<AvailabeVechileDto> seaAllAvalVechiles(long mob, String destinationlocation) {
//		
//		double[] coords = cs.getCoordinates(destinationlocation);
//		  responcestucture<AvailabeVechileDto> rs = new responcestucture<>();
//	   
//	    if (coords == null) {
//	      
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid destination location");
//	        rs.setData(null);
//	        return rs;
//	    }
//	    
//	    
//		
//		Customer c=cr.findByMob(mob);
//				if(c==null) {
//					  rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//				        rs.setMasg(" Customer not find");
//				        rs.setData(null);
//				        return rs;
//				}
//	Booking b=new Booking();
////	
////	b.setSourcelocation(c.getCurrentLocation());
////	b.setDestinationlocation(destinationlocation);
//	
//	String SourceLocation=c.getCurrentLocation();
//	String cleanSource = SourceLocation.split(",")[0];
//
//	double[] coords_SL = cs.getCoordinates(cleanSource);
//	if (coords_SL == null) {
//	    rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	    rs.setMasg("Invalid source location: " + SourceLocation);
//	    rs.setData(null);
//	    return rs;
//	}
//	double sourceLat = coords_SL[0];
//	double sourceLon = coords_SL[1];
//	
//	String destinationLocation=destinationlocation;
//	double destinationeLat=coords[0];
//	double  destinationLon=coords[1];
//	
//	double distance =cds.calculateDistance(sourceLat, sourceLon, destinationeLat, destinationLon) ;
//	
//  
//
//AvailabeVechileDto avd=new AvailabeVechileDto();
//  List<Vehicle>vlist=  vr.findByCurrentCity(SourceLocation);
//
//  
//
//    for(Vehicle x:vlist) {
//    double priceperkm=	x.getPricePerKm();
//    	int averagespeed=x.getCapacity();
//    	
// b.setFare(priceperkm*averagespeed);
// double fare=b.getFare();
// 
//double d1=distance/averagespeed;
//
//b.setEstimatedtimerequired(d1+"");
//String estimatedTime=b.getDestinationlocation();
//
//
//VechileDetails vd=new VechileDetails();
//vd.setFare(fare);
//vd.setEstimatedtimerequired(estimatedTime);
//vd.setV(x);
//avd.getAvailablevechicle().add(vd);
//
// 
//    }
//    
//	
//	return rs;
//	
//	
//	
//		
//		
//	}
//	
	

//	public responcestucture<AvailabeVechileDto> seaAllAvalVechiles(long mob, String destinationlocation) {
//
//	    double[] coords = cs.getCoordinates(destinationlocation);
//	    responcestucture<AvailabeVechileDto> rs = new responcestucture<>();
//
//	    if (coords == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid destination location");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    Customer c = cr.findByMob(mob);
//	    if (c == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Customer not found");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    String SourceLocation = c.getCurrentLocation();
//	    String cleanSource = SourceLocation.split(",")[0]; // FIX
//
//	    double[] coords_SL = cs.getCoordinates(cleanSource);
//	    if (coords_SL == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid source location: " + cleanSource);
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    double distance = cds.calculateDistance(coords_SL[0], coords_SL[1], coords[0], coords[1]);
//
//	    AvailabeVechileDto avd = new AvailabeVechileDto();
//	    List<Vehicle> vlist = vr.findByCurrentCity(cleanSource);
//
//	    for (Vehicle x : vlist) {
//	        double priceperkm = x.getPricePerKm();
//	        int averagespeed = x.getCapacity();
//
//	        double fare = priceperkm * distance;
//	        double time = distance / averagespeed;
//
//	        VechileDetails vd = new VechileDetails();
//	        vd.setFare(fare);
//	        vd.setEstimatedtimerequired(time + " hrs");
//	        vd.setV(x);
//	        List<VechileDetails> availablevechicle = new ArrayList<>();
//
//	       availablevechicle.add(vd);
//
//        avd.setAvailablevechicle(availablevechicle);
//	    }
//
//	    rs.setStatuscode(HttpStatus.OK.value());
//	    rs.setMasg("Available vehicles fetched successfully");
//	    rs.setData(avd);
//
//	    return rs;
//	}

//	public responcestucture<AvailabeVechileDto> seaAllAvalVechiles(long mob, String destinationlocation) {
//
//	    responcestucture<AvailabeVechileDto> rs = new responcestucture<>();
//
//	    // 1️⃣ Destination coordinates
//	    double[] coords = cs.getCoordinates(destinationlocation);
//	    if (coords == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid destination location");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    // 2️⃣ Customer location
//	    Customer c = cr.findByMob(mob);
//	    if (c == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Customer not found");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    String sourceLocation = c.getCurrentLocation();
//	    String cleanSource = sourceLocation.split(",")[0]; 
//	    
//    double[] coords_SL = cs.getCoordinates(cleanSource);
//
//	    if (coords_SL == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid source location: " + sourceLocation);
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    // Extract lat/lon
//	    double sourceLat = coords_SL[0];
//	    double sourceLon = coords_SL[1];
//	    double destinationLat = coords[0];
//	    double destinationLon = coords[1];
//
//	    // 3️⃣ Calculate distance
//	    double distance = cds.calculateDistance(sourceLat, sourceLon, destinationLat, destinationLon);
//
//	    // 4️⃣ Prepare DTO
//	    AvailabeVechileDto avd = new AvailabeVechileDto();
//	    avd.setC(c);
//	    avd.setDistance(distance);
//	    avd.setSourceLocation(sourceLocation);
//	    avd.setDestinationLocation(destinationlocation);
//
//	    // 5️⃣ Fetch vehicles at source location
//	    List<Vehicle> vlist = vr.findByCurrentCity(sourceLocation);
//
//	    for (Vehicle x : vlist) {
//	        double fare = distance * x.getPricePerKm();
//	        double time = distance / x.getCapacity();
//
//	        VechileDetails vd = new VechileDetails();
//	        vd.setFare(fare);
//	        vd.setEstimatedtimerequired(time + " hr");
//	        vd.setV(x);
//
//	        avd.getAvailablevechicle().add(vd);
//	    }
//
//	    // 6️⃣ Final response
//	    rs.setStatuscode(HttpStatus.OK.value());
//	    rs.setMasg("Available vehicles fetched successfully");
//	    rs.setData(avd);
//
//	    return rs;
//	}
//	public responcestucture<AvailabeVechileDto> seaAllAvalVechiles(long mob, String destinationlocation) {
//
//	    responcestucture<AvailabeVechileDto> rs = new responcestucture<>();
//
//	    // 1️⃣ Destination Coordinates
//	    double[] destCoords = cs.getCoordinates(destinationlocation);
//	    if (destCoords == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid destination location");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    // 2️⃣ Customer
//	    Customer c = cr.findByMob(mob);
//	    if (c == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Customer not found");
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    String sourceCity = c.getCurrentLocation(); // already stored as only city
//
//	    // 3️⃣ Convert source city to coordinates
//	    double[] srcCoords = cs.getCoordinates(sourceCity);
//	    if (srcCoords == null) {
//	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
//	        rs.setMasg("Invalid source location: " + sourceCity);
//	        rs.setData(null);
//	        return rs;
//	    }
//
//	    // 4️⃣ Extract Lat & Long
//	    double sourceLat = srcCoords[0];
//	    double sourceLon = srcCoords[1];
//	    double destLat = destCoords[0];
//	    double destLon = destCoords[1];
//
//	    // 5️⃣ Calculate Distance
//	    double distance = cds.calculateDistance(sourceLat, sourceLon, destLat, destLon);
//
//	    // 6️⃣ Prepare DTO
//	    AvailabeVechileDto avd = new AvailabeVechileDto();
//	    avd.setC(c);
//	    avd.setDistance(distance);
//	    avd.setSourceLocation(sourceCity);
//	    avd.setDestinationLocation(destinationlocation);
//
//	    // 7️⃣ Get Available Vehicles in same city
//	    List<Vehicle> vlist = vr.findByCurrentCityIgnoreCase(sourceCity);
//
//	    for (Vehicle x : vlist) {
//	        double fare = distance * x.getPricePerKm();
//	        double time = distance / x.getCapacity(); // 40 km/h avg speed
//
//	        VechileDetails vd = new VechileDetails();
//	        vd.setFare(fare);
//	        vd.setEstimatedtimerequired(time + " hr");
//	        vd.setV(x);
//         
//	        avd.getAvailablevechicle().add(vd);
//	    }
//
//	    // 8️⃣ Final Response
//	    rs.setStatuscode(HttpStatus.OK.value());
//	    rs.setMasg("Available vehicles fetched successfully");
//	    rs.setData(avd);
//	    return rs;
//	}
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

<<<<<<< HEAD
	        double avgSpeed = x.getAverageSpeed(); 
=======
	        double avgSpeed = x.getAverageSpeed();// 40 km/h average
>>>>>>> bc64de6c87ccd71b993ade8b1939a4cc54294844
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
