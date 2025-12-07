package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.service.CustomerService;

@RestController
public class CustomerDtoController {
@Autowired
	private CustomerService cs;
	@PostMapping("/registercustdto")
	public responcestucture<Customer> registercustdto(@RequestBody CustomerDto cd) {
		return cs.registerCust(cd);
	}
	
	//public void bookVechile(@)
    //Delete By using Mobile Id
    @DeleteMapping("/deletcustomermob")
    public responcestucture<Customer> deleteDriver(@RequestParam long mob) {
    	return  cs.deleteCustMob(mob);
    
}
    @GetMapping("/findCust")
    public responcestucture<Customer> findCustomer(@RequestParam long mob) {
    	return cs.findCust(mob);
    }
    
    @PostMapping("/seaallavailvech")
    public void SeaAllAvailableVechile(@RequestParam long mob,String destinationlocation) {
    	cs.seaAllAvalVechiles(mob,destinationlocation);
}
}