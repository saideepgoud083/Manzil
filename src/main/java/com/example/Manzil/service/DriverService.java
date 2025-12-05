package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.DriverDto;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.DriverRepository;
import com.example.Manzil.repository.VechileRepositry;
import com.example.Manzil.service.Exception.DataIntegrityViolationException;
import com.example.Manzil.service.Exception.DriverAlreadyExistsException;
import com.example.Manzil.service.Exception.DriverNotFoundException;


@Service
public class DriverService {
     @Autowired
	private  DriverRepository dr ;
	@Autowired
	private VechileRepositry vr;
	@Autowired
	private LocationService ls;
	

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
	
	public responcestucture<Driver> registerDriver(DriverDto dto) {

	    responcestucture<Driver> rs = new responcestucture<>();

	    // 1️⃣ Check if driver already exists using license number
	    Driver dl = dr.findByLicenseNum(dto.getLicenseNum());
	    if (dl != null) {
	        throw new DriverAlreadyExistsException();  // same as doctor already exists exception
	    }
	    Driver d = new Driver();
	    // 2️⃣ Create Vehicle
	    Vehicle v = new Vehicle();
	    v.setVehicleName(dto.getVehicleName());
	    v.setVehicleNum(dto.getVehicleNum());
	    v.setType(dto.getVehicleType());
	    v.setModel(dto.getVehicleModel());
	    v.setCapacity(dto.getCapacity());
	    v.setPricePerKm(dto.getPricePerKm());
         v.setVehicleId(d.getDriverId());
         
	    Vehicle savedVehicle = vr.save(v);

	    // 3️⃣ Create Driver object
	   
	    d.setLicenseNum(dto.getLicenseNum());
	    d.setUpiId(dto.getUpiId());
	    d.setDriverName(dto.getDriverName());
	    d.setAge(dto.getAge());
	    d.setMobileNum(dto.getMobNum());
	    d.setGender(dto.getGender());
	    d.setMailId(dto.getMailId());
	    
	    

	    // Set vehicle inside driver
	    d.setV(savedVehicle);

	    // 4️⃣ Save Driver
	    Driver saved = dr.save(d);

	    // 5️⃣ Prepare response
	    rs.setStatuscode(HttpStatus.CREATED.value());
	    rs.setMasg("Driver registered successfully");
	    rs.setData(saved);

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
<<<<<<< HEAD
//        
=======
//
>>>>>>> ae676fc6c5ba6da8698638610facc3c1054f0352
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
	    Vehicle v1 = d.getV();
	    String loc = ls.getLocation(latitude,longitude);
//        Vehicle v = new   Vehicle();
//        v.setCurrentCity(loc);
	    v1.setCurrentCity(loc);

	    vr.save(v1);
	    

	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Driver location updated successfully");
	    rs.setData(d);

	    return rs;
	}
	



	

}
