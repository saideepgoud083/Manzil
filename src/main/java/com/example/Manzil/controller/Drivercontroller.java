package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.Dto.DriverDto;
import com.example.Manzil.service.DriverService;

@RestController
public class Drivercontroller {
	
	@Autowired
	private DriverService ds ;
	
	
	@PostMapping("/regdriver")
	public void registerDriver(@RequestBody DriverDto dto ) {
		
		ds.regdriver(dto);
		
	}
	
	
	
	
	
	
	
	

}
