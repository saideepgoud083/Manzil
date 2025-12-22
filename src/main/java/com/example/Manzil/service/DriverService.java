package com.example.Manzil.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.DriverDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.DriverRepository;
import com.example.Manzil.repository.VechileRepositry;
import com.example.Manzil.repository.bookingRepository;
import com.example.Manzil.service.Exception.DataIntegrityViolationException;
import com.example.Manzil.service.Exception.DriverAlreadyExistsException;
import com.example.Manzil.service.Exception.DriverNotFoundException;
import com.example.Manzil.service.Exception.InvalidOtpException;
import com.example.Manzil.service.Exception.bookingnotfind;
import com.example.Manzil.service.Exception.thsibookingidnotfound;


@Service
public class DriverService {
     @Autowired
	private  DriverRepository dr ;
	@Autowired
	private VechileRepositry vr;
	@Autowired
	private LocationService ls;
	@Autowired
	private bookingRepository br;

	
	@Autowired
	private  EmailService es;
//	
//	
//	public void regdriver(DriverDto dto) {
//		
//		
//		 Vehicle v = new Vehicle();
//		 
//		 v.setVehicleName(dto.getVehicleName());
//		 v.setVehicleNum(dto.getVehicleNum());
//		 v.setType(dto.getVehicleType());
//		 v.setModel(dto.getVehicleModel());
//		 v.setCapacity(dto.getCapacity());
//		   v.setPricePerKm(dto.getPricePerKm());
//		
//		Driver d = new Driver();
//		
//		d.setLicenseNum(dto.getLicenseNum());
//		d.setUpiId(dto.getUpiId());
//		d.setDriverName(dto.getDriverName());
//		d.setAge(dto.getAge());
//		d.setMobileNum(dto.getMobNum());
//		d.setGender(dto.getGender());
//		d.setMailId(dto.getMailId());
//	     d.setV(v);
//	    
//	    
//	   dr.save(d);
//		
//	}
//	public void regdriver(DriverDto dto) {
//		
//		
//		 Vehicle v = new Vehicle();
//		 
//		 v.setVehicleName(dto.getVehicleName());
//		 v.setVehicleNum(dto.getVehicleNum());
//		 v.setType(dto.getVehicleType());
//		 v.setModel(dto.getVehicleModel());
//		 v.setCapacity(dto.getCapacity());
//		   v.setPricePerKm(dto.getPricePerKm());
//		
//		  
//		Driver d = new Driver();
//		
//		d.setLicenseNum(dto.getLicenseNum());
//		d.setUpiId(dto.getUpiId());
//		d.setDriverName(dto.getDriverName());
//		d.setAge(dto.getAge());
//		d.setMobileNum(dto.getMobNum());
//		d.setGender(dto.getGender());
//		d.setMailId(dto.getMailId());
//	
//	   dr.save(d);
//	   vr.save(v);
//		
//	}
//	public responcestucture<Driver> registerDriver(DriverDto dto) {
//
//	    responcestucture<Driver> rs = new responcestucture<>();
//
//	    // ⿡ Check if driver already exists using license number
//	    Driver dl = dr.findByLicenseNum(dto.getLicenseNum());
//	    if (dl != null) {
//	        throw new DriverAlreadyExistsException();  // same as doctor already exists exception
//	    }
//
//	    // ⿢ Create Vehicle
//	    Driver d = new Driver();
//	    // ⿢ Create Vehicle
//	   
//
//	    // ⿣ Create Driver object
//	   
//	    d.setLicenseNum(dto.getLicenseNum());
//	    d.setUpiId(dto.getUpiId());
//	    d.setDriverName(dto.getDriverName());
//	    d.setAge(dto.getAge());
//	    d.setMobileNum(dto.getMobNum());
//	    d.setGender(dto.getGender());
//	    d.setMailId(dto.getMailId());
//	    
//	    
//	    Driver saved = dr.save(d);
//	    Vehicle v = new Vehicle();
//	    v.setVehicleName(dto.getVehicleName());
//	    v.setVehicleNum(dto.getVehicleNum());
//	    v.setType(dto.getVehicleType());
//	    v.setModel(dto.getVehicleModel());
//	    v.setCapacity(dto.getCapacity());
//	    v.setPricePerKm(dto.getPricePerKm());
//	  //  v.setVehicleId(saved.getDriverId());
//	    v.setAverageSpeed(dto.getAverageSpeed());
//	    v.setD(saved);
//	    Vehicle savedVehicle = vr.save(v);
//	    // Set vehicle inside driver
//	  
//	    // ⿤ Save Driver
//	    saved.setV(savedVehicle);
//	    dr.save(saved);
//
//	    // ⿥ Prepare response
//	    rs.setStatuscode(HttpStatus.CREATED.value());
//	    rs.setMasg("Driver registered successfully");
//	    rs.setData(saved);
//
//	    return rs;
//	}
	public responcestucture<Driver> registerDriver(DriverDto dto) {

	    responcestucture<Driver> rs = new responcestucture<>();

	    Driver d = new Driver();
	    d.setLicenseNum(dto.getLicenseNum());
	    d.setUpiId(dto.getUpiId());
	    d.setDriverName(dto.getDriverName());
	    d.setAge(dto.getAge());
	    d.setMobileNum(dto.getMobNum());
	    d.setGender(dto.getGender());
	    d.setMailId(dto.getMailId());

	    // Create Vehicle
	    Vehicle v = new Vehicle();
	    v.setVehicleName(dto.getVehicleName());
	    v.setVehicleNum(dto.getVehicleNum());
	    v.setType(dto.getVehicleType());
	    v.setModel(dto.getVehicleModel());
	    v.setCapacity(dto.getCapacity());
	    v.setAverageSpeed(dto.getAverageSpeed());
	    v.setPricePerKm(dto.getPricePerKm());
	    v.setAvailabilityStatus("Available");

	    // Attach both sides
	    v.setDriver(d);   // child → parent
	    d.setVehicle(v);  // parent → child

	    // 👉 SAVE DRIVER FIRST (to generate driverId)
	    Driver saved = dr.save(d);

	    // 👉 VEHICLE WILL AUTOMATICALLY GET SAME ID DUE TO @MapsId

	    
	    rs.setStatuscode(HttpStatus.CREATED.value());
	    rs.setMasg("Driver registered successfully");
	    rs.setData(saved);
	    
	  
	    
	   es. sendMail(d.getMailId(),"Registeration Successfully "+d.getDriverName()
	   		,"Driver registered successfully");
	    
	    
	    
	    return rs;
	}

	
	//find
	public responcestucture<Driver> findDriver(int id) {

	    responcestucture<Driver> rs = new responcestucture<>();

	    Driver d = dr.findById(id).orElseThrow(() -> new DataIntegrityViolationException("Driver not found with ID: " + id));


	    
	    rs.setStatuscode(HttpStatus.FOUND.value());
	    rs.setMasg("Driver found successfully");
	    rs.setData(d);

	    return rs;
	}

	//update
//	public responcestucture<Driver> updateDriver(int id, DriverDto dto) {
//
//	    responcestucture<Driver> rs = new responcestucture<>();
//
//	    Driver d = dr.findById(id)
//	                 .orElseThrow(() -> new DataIntegrityViolationException("Driver not found, cannot update"));
//
//	    // Update driver fields
//	    d.setLicenseNum(dto.getLicenseNum());
//	    d.setUpiId(dto.getUpiId());
//	    d.setDriverName(dto.getDriverName());
//	    d.setAge(dto.getAge());
//	    d.setMobileNum(dto.getMobNum());
//	    d.setGender(dto.getGender());
//	    d.setMailId(dto.getMailId());

//	    // Update vehicle
//	    Vehicle v = d.getV();
//	    v.setVehicleName(dto.getVehicleName());
//	    v.setVehicleNum(dto.getVehicleNum());
//	    v.setType(dto.getVehicleType());
//	    v.setModel(dto.getVehicleModel());
//	    v.setCapacity(dto.getCapacity());
//	    v.setPricePerKm(dto.getPricePerKm());
//
//	    vr.save(v);
//
//	    Driver saved = dr.save(d);
//
//	    rs.setStatuscode(HttpStatus.OK.value());
//	    rs.setMasg("Driver updated successfully");
//	    rs.setData(saved);
//
//	    return rs;
//	}
	
	//delete
	public responcestucture<String> deleteDriver(int id) {

	    responcestucture<String> rs = new responcestucture<>();

	    Driver d = dr.findById(id)
	                 .orElseThrow(() -> new DataIntegrityViolationException("Driver not found, cannot delete"));

	    dr.delete(d);

	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Driver deleted successfully");
	    rs.setData("Driver removed with ID: " + id);

	    return rs;
	}
//update
	public responcestucture<Driver> updateDriverLocation(long mobile, double latitude, double longitude) {
	    
	    responcestucture<Driver> rs = new responcestucture<>();

	    // find driver by mobile number
	    Driver d = dr.findByMobileNum(mobile);

	    if (d == null) {
	        throw new DriverNotFoundException();
	    }

	    // update vehicle latitude & longitude
	    Vehicle v1 = d.getVehicle();
	    String loc = ls.getCity(latitude,longitude);
//        Vehicle v = new   Vehicle();
//        v.setCurrentCity(loc);
	    v1.setCurrentCity(loc);

	    vr.save(v1);
	    

	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Driver location updated successfully");
	    rs.setData(d);

	    return rs;
	}

	public responcestucture<Driver> delDriverbymob(long mob) {
		// TODO Auto-generated method stub
		Driver d=dr.findByMobileNum(mob);
		dr.delete(d);
		   responcestucture<Driver> rs = new responcestucture<>();
		   rs.setStatuscode(HttpStatus.OK.value() );
		    rs.setMasg("Driver found successfully");
		    rs.setData(d);
		    return rs;
		   
	}


/***********updating driver and vechile statuss*/////
	public responcestucture<Driver> updatedrivervechilestatu(long mobnum , String status ) {
		     
		  Driver d = dr.findByMobileNum(mobnum);

		    if (d == null) {
		        throw new DriverNotFoundException();
		    }
		    
		     d.setDriverStatus(status);
		     d.getVehicle().setAvailabilityStatus(status);
		    
		Driver updated =    dr.save(d);
		
		 responcestucture<Driver> rs = new responcestucture<>();
		   rs.setStatuscode(HttpStatus.OK.value() );
		    rs.setMasg("Driver updated successfully");
		    rs.setData(updated);
		    return rs;

		
	}
	
	/***********updating driver and vechile statuss*/////
	public responcestucture<Driver> updatedrivervechilestatu1(long mobnum , String status ) {
		     
		  Driver d = dr.findByMobileNum(mobnum);





		    if (d == null) {
		        throw new DriverNotFoundException();
		    }
		    
		     d.setDriverStatus(status);
		     d.getVehicle().setAvailabilityStatus(status);
		    
		Driver updated =    dr.save(d);
		 responcestucture<Driver> rs = new responcestucture<>();
		   rs.setStatuscode(HttpStatus.OK.value() );
		    rs.setMasg("Driver updated successfully");
		    rs.setData(updated);
		    return rs;

		
	}


	public responcestucture<Driver> updateaverageSpeed(long mobnum ,double averageSpeed ) {
	     
		  Driver d = dr.findByMobileNum(mobnum);





		    if (d == null) {
		        throw new DriverNotFoundException();
		    }
		    
		   
		     d.getVehicle().setAverageSpeed(averageSpeed);
		    
		Driver updated =    dr.save(d);
		 responcestucture<Driver> rs = new responcestucture<>();
		   rs.setStatuscode(HttpStatus.OK.value() );
		    rs.setMasg("Driver updated successfully");
		    rs.setData(updated);
		    return rs;

		
	}
//	 public ResponseEntity<responcestucture<Booking>> cancelRideDriver(
//	            int driverId, int bookingId) {
//
//	        responcestucture<Booking> rs = new responcestucture<>();
//	        
////	        Driver d=vr.findDriverbyId(driverId);
//
//	        // 1️⃣ Get today date
//	        String todaysDate = LocalDate.now().toString();
//
//	        // 2️⃣ Fetch driver
//	        Driver driver = dr.findById(driverId)
//	                .orElseThrow(DriverNotFoundException::new);
//
//	        Vehicle v=new Vehicle();
//	        // 3️⃣ Get today's bookings of driver
//	        List<Booking> blist =
//	                br.findTodayBookingsByDriverId(driverId, todaysDate);
//
//	        // 4️⃣ Get booking
//	        Booking booking = br.findById(bookingId)
//	                .orElseThrow(thsibookingidnotfound::new);
//
//	        // 5️⃣ Count cancellations
//	        int cancelCount = 0;
//	        for (Booking b : blist) {
//	            if ("CANCELLED_BY_DRIVER".equals(b.getBookingStatus())) {
//	                cancelCount++;
//	            }
//	        }
//
//	        // 6️⃣ Apply rules
//	        if (cancelCount >= 4) {
//	            driver.setDriverStatus("BLOCKED");
//	            booking.setBookingStatus("CANCELLED");
//	            rs.setMasg("Driver blocked due to multiple cancellations today");
//	        } else {
//	            booking.setBookingStatus("CANCELLED_BY_DRIVER");
//	            rs.setMasg("Ride cancelled by driver successfully");
//	        }
//
//	        // 7️⃣ Save
//	        dr.save(driver);
//	        Booking savedBooking = br.save(booking);
//
//	        // 8️⃣ Response
//	        rs.setStatuscode(HttpStatus.OK.value());
//	        rs.setData(savedBooking);
//
//	        return new ResponseEntity<>(rs, HttpStatus.OK);
//	    }

	
	public ResponseEntity<responcestucture<Booking>> cancelbooking(int driverId, int bookingid) {
		int cancelcount=0;
		String today = LocalDate.now().toString(); // "2025-12-17"

		List<Booking> blist = br.findByDriver_DriverIdAndDatebooked(driverId,today);
		Booking book = br.findById(bookingid).orElseThrow(()->new bookingnotfind());
		for(Booking b:blist)
		{
			if ("cancelledbydriver".equalsIgnoreCase(b.getBookingStatus()))
			{
			    cancelcount++;
			}

		}
		Driver d = dr.findById(driverId).orElseThrow(()->new DriverNotFoundException());
		if(cancelcount>=4)
		{
			d.setDriverStatus("BLOCKED");
			book.setBookingStatus("CANCELLED");
		}
		else if(cancelcount<4)
		{
			book.setBookingStatus("CANCELLED");
		}
		dr.save(d);
		br.save(book);
		responcestucture<Booking> rs = new responcestucture<Booking>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMasg("Booking cancelled successfully");
		rs.setData(book);
		  es. sendMail(d.getMailId(),"Cancelled Successfully "+d.getDriverName()
	   		,"Driver cancelled successfully");
		return new ResponseEntity<responcestucture<Booking>>(rs,HttpStatus.OK);
	}
	public ResponseEntity<responcestucture<String>> startride(int otp,int bookingid) 
	{	
		Booking b = br.findById(bookingid).orElseThrow(()->new bookingnotfind());
		if(otp!=b.getOtp()) throw new InvalidOtpException();
		responcestucture<String> rs = new responcestucture<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMasg("OTP verified successfully");
		rs.setData("OTP verified successfully");
		return new ResponseEntity<responcestucture<String>>(rs,HttpStatus.OK);
	}
}

	        
	    


