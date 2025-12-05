package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.DriverDto;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.service.DriverService;

@RestController
public class Drivercontroller {
	
	@Autowired
	private DriverService ds ;
	
	@RestController
	public class DriverController {

	    @Autowired
	    private DriverService ds;

	    @PostMapping("/regdriver")
	    public responcestucture<Driver> registerDriver(@RequestBody @Validated DriverDto dto) {
	        return ds.registerDriver(dto);
	    }
	}

	
	
	// ---------------- FIND ----------------
    @GetMapping("/find/{id}")
    public responcestucture<Driver> findDriver(@PathVariable int id) {
        return ds.findDriver(id);
    }

    // ---------------- UPDATE ----------------
    @PutMapping("/update/{id}")
    public responcestucture<Driver> updateDriver(@PathVariable int id, @RequestBody DriverDto dto) {
        return ds.updateDriver(id, dto);
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/delete/{id}")
    public responcestucture<String> deleteDriver(@PathVariable int id) {
        return ds.deleteDriver(id);
    }
	
	

}
