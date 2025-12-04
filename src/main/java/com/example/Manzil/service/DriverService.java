package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Manzil.Dto.DriverDto;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.DriverRepository;

@Service
public class DriverService {
     @Autowired
	private  DriverRepository dr ;
	
	
	
	
	public void regdriver(DriverDto dto) {
		
		
		 Vehicle v = new Vehicle();
		 
		 v.setVehicleName(dto.getVehicleName());
		 v.setVehicleNum(dto.getVehicleNum());
		 v.setType(dto.getVehicleType());
		 v.setModel(dto.getVehicleModel());
		 v.setCapacity(dto.getCapacity());
		   v.setPricePerKm(dto.getPricePerKm());
		
		Driver d = new Driver();
		
		d.setLicenseNum(dto.getLicenseNum());
		d.setUpiId(dto.getUpiId());
		d.setDriverName(dto.getDriverName());
		d.setAge(dto.getAge());
		d.setMobileNum(dto.getMobNum());
		d.setGender(dto.getGender());
		d.setMailId(dto.getMailId());
	
	   dr.save(d);
		
	}
	
	

}
