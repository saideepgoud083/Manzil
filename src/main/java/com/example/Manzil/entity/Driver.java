package com.example.Manzil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Driver {
	
	private int driverId ;
	
	private String licenseNum;
	
	private String upiId;
	
	private String driverName;
	
	private String driverStatus;
	
	private int age ;
	
	private long mobileNum;
	
	private String gender ;
	
	private String mailId;
	
	@OneToOne
	
	private Vehicle v ;
	

	
	
	
	
	
	
	
	

}
