package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.BookingDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.service.BookingService;

@RestController
public class BookingController {
@Autowired
	BookingService bs;
	@PostMapping("/bookVechile")
	public responcestucture<Booking> bookVechile(@RequestParam long mob, @RequestBody BookingDto bd ) {
		return bs.bookVechilee(mob,bd);
	}
	 
	
	@GetMapping("/seeallbooingcoustomer")
	public void SeeallbookingHistory(@RequestParam long mob) {
		
		 bs.SeeallbookingHistory(mob);
		
	}
}
