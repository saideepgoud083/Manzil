package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.Dto.BookingDto;
import com.example.Manzil.service.BookingService;

@RestController
public class BookingController {
@Autowired
	BookingService bs;
	@PostMapping("/bookVechile")
	public void bookVechile(@RequestParam long mob, @RequestBody BookingDto bd ) {
		bs.bookVechilee(mob,bd);
	}
}
