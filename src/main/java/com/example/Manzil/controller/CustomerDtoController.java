package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.Dto.CustomerDto;
import com.example.Manzil.service.CustomerService;

@RestController
public class CustomerDtoController {
@Autowired
	private CustomerService cs;
	@PostMapping("/registercustdto")
	public void registercustdto(@RequestBody CustomerDto cd) {
		cs.registerCust(cd);
	}
	
	
	
	
}
