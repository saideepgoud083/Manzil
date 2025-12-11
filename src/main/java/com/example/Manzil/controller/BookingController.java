package com.example.Manzil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.BookingDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.service.BookingService;

@RestController
public class BookingController {
@Autowired
	BookingService bs;
	@PostMapping("/bookVechile")
	public responcestucture<Booking> bookVechile(@RequestParam long mob, @RequestBody BookingDto bd ) {
	return	bs.bookVechilee(mob,bd);
	}
//	@GetMapping("/seebookinghistory")
//	public ResponseEntity<responcestucture<List<Booking>>> seeallbookinghistoryofCustomer(@RequestParam long mob) {
//	return	bs.seebookinghistory(mob);
//		
//	}
////	@GetMapping("/seeDriverbookhistory")
//	public ResponseEntity<responcestucture<List<Booking>>> seeallbookinghistoryofDriver(@RequestParam long mob) {
//	return	bs.seeDriverbookhistory(mob);
//		
//	}
	
}
