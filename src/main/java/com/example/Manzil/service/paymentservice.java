package com.example.Manzil.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.ActiveBookingDto;
import com.example.Manzil.Dto.paymentdto;
import com.example.Manzil.Dto.upiPaymentDTO;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Payment;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.repository.VechileRepositry;
import com.example.Manzil.repository.bookingRepository;
import com.example.Manzil.repository.paymentrepository;
import com.example.Manzil.service.Exception.bookingnotfind;

@Service
public class paymentservice {
	@Autowired
private paymentrepository pr ;
	@Autowired
	bookingRepository br;
	@Autowired
	private CustomerRepositry cr;
	@Autowired
	private VechileRepositry vr;
	public ResponseEntity<responcestucture<paymentdto>> completepayment(int bookingid, String paymenttype) {
		// TODO Auto-generated method stub
		
	Booking b =	br.findById(bookingid).orElseThrow(()->new bookingnotfind());
	
	b.setBookingStatus("compleled");
		b.setPaymentStatus("paid");
	  Customer c = b.getCust();
	  c.setFlag(false);
		Vehicle v =b.getVeh();
		v.setAvailabilityStatus("avilable");
		Payment p = new Payment();
		p.setV(v);
		p.setCustomer(c);
		p.setBooking(b);
		p.setAmount(b.getFare());
		p.setPaymentype(paymenttype);
		Customer cs =cr.save(c);
		          Vehicle vs =    vr.save(v);
		     Booking bb =   br.save(b);
		  Payment pp =   pr.save(p);
		  
		paymentdto pdto = new paymentdto();
		
		pdto.setB(b);
		pdto.setC(c);
		pdto.setV(v);
		pdto.setP(p);
		responcestucture<paymentdto> rs = new responcestucture<paymentdto>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMasg("payment do using "+paymenttype);
		rs.setData(pdto);
		 return new ResponseEntity<responcestucture<paymentdto>>(rs,HttpStatus.OK);

	}
	
//	
//	
//	public ResponseEntity<responcestucture<upiPaymentDTO>> paymentService(int bookingid, String paytype) {
//
//		Booking b =	br.findById(bookingid).orElseThrow(()->new bookingnotfind());
//	    String upiid = b.getVeh().getDriver().getUpiId();
//	    String amount = String.format("%.2f", b.getFare());
//	    String upiData = "upi://pay?pa=" + upiid +"&pn=FindRide" +"&am=" + amount +"&cu=INR";
//
//	    String encodedUpiData = URLEncoder.encode(upiData, StandardCharsets.UTF_8);
//
//	    String qrUrl = "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" + encodedUpiData;
//
//	    RestTemplate rt = new RestTemplate();
//	    byte[] qrBytes = rt.getForObject(qrUrl, byte[].class);
//
//	    upiPaymentDTO updto = new upiPaymentDTO();
//	    updto.setFare(amount);
//	    updto.setQr(qrBytes);
//
//	    responcestucture<upiPaymentDTO> rs = new responcestucture<>();
//	    rs.setStatuscode(HttpStatus.OK.value());
//	    rs.setMasg("UPI QR generated successfully");
//	    rs.setData(updto);
//
//	    return new ResponseEntity<responcestucture<upiPaymentDTO>>(rs, HttpStatus.OK);
//	}
//	
//	
	public ResponseEntity<responcestucture<upiPaymentDTO>> paymentService(int bookingid, String paytype) {

	    Booking b = br.findById(bookingid)
	                  .orElseThrow(() -> new bookingnotfind());

	    String upiid = b.getVeh().getDriver().getUpiId();

	    // 🔹 double fare (entity value)
	    double fare = b.getFare();

	    // 🔹 string ONLY for UPI QR
	    String amountForUpi = String.format("%.2f", fare);

	    String upiData =
	        "upi://pay?pa=" + upiid +
	        "&pn=FindRide" +
	        "&am=" + amountForUpi +
	        "&cu=INR";

	    String encodedUpiData =
	        URLEncoder.encode(upiData, StandardCharsets.UTF_8);

	    String qrUrl =
	        "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" + encodedUpiData;

	    RestTemplate rt = new RestTemplate();
	    byte[] qrBytes = rt.getForObject(qrUrl, byte[].class);

	    upiPaymentDTO updto = new upiPaymentDTO();
	    updto.setFare(fare);      // ✅ DOUBLE
	    updto.setQr(qrBytes);

	    responcestucture<upiPaymentDTO> rs = new responcestucture<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("UPI QR generated successfully");
	    rs.setData(updto);

	    return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	
	
	
	
	
public ResponseEntity<responcestucture<paymentdto>> confrimPaymentCollection(int bookingid, String paytype) {
		
		return completepayment(bookingid, paytype);

	}
}
