package com.example.Manzil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.paymentdto;
import com.example.Manzil.Dto.upiPaymentDTO;
import com.example.Manzil.service.paymentservice;

@RestController
@RequestMapping("/ridecompleted")  
public class paymentcontroller {

	
	@Autowired
	private  paymentservice ps ;
	
	@PostMapping("/completepaymentbycash")
	public ResponseEntity<responcestucture<paymentdto>> completepayment(@RequestParam int bookingid , @RequestParam String paymenttype) {
		
		return  ps.completepayment(bookingid,paymenttype);
		
	}
	
	
	@PostMapping("/paymentService")
public ResponseEntity<responcestucture<upiPaymentDTO>> paymentService(@RequestParam int bookingid , @RequestParam String paymenttype) {
		
		return  ps.paymentService(bookingid,paymenttype);
		
	}
	
	
	@GetMapping("/paymentconfirmed")
	 public ResponseEntity<responcestucture<paymentdto>> confrimPaymentCollection(@RequestParam int bookingid,@RequestParam String paytype)
	 {
		 return ps.confrimPaymentCollection(bookingid,paytype);
	 }
	
	
	
	
	
	
}
