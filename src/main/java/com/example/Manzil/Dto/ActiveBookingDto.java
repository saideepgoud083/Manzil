package com.example.Manzil.Dto;

import com.example.Manzil.entity.Booking;

public class ActiveBookingDto {

	private String Customername;
	
	private long Customermobnum;
	
	private Booking bookng ;
	
	private String currentlocation ;

	public ActiveBookingDto() {
		super();
	}

	public ActiveBookingDto(String customername, long customermobnum, Booking bookng, String currentlocation) {
		super();
		Customername = customername;
		Customermobnum = customermobnum;
		this.bookng = bookng;
		this.currentlocation = currentlocation;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public long getCustomermobnum() {
		return Customermobnum;
	}

	public void setCustomermobnum(long customermobnum) {
		Customermobnum = customermobnum;
	}

	public Booking getBookng() {
		return bookng;
	}

	public void setBookng(Booking bookng) {
		this.bookng = bookng;
	}

	public String getCurrentlocation() {
		return currentlocation;
	}

	public void setCurrentlocation(String currentlocation) {
		this.currentlocation = currentlocation;
	}
	
	
	
	
	
	
	
	
	
}
