package com.example.Manzil.Dto;

import java.util.ArrayList;
import java.util.List;

import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.VechileDetails;

public class AvailabeVechileDto {
 private Customer c;
 private double distance;
 private String sourceLocation;
 private String DestinationLocation;
 
 //private List<VechileDetails> availablevechicle;
 private List<VechileDetails> availablevechicle = new ArrayList<>();


public AvailabeVechileDto(Customer c, double distance, String sourceLocation, String destinationLocation,
		List<VechileDetails> availablevechicle) {
	super();
	this.c = c;
	this.distance = distance;
	this.sourceLocation = sourceLocation;
	DestinationLocation = destinationLocation;
	this.availablevechicle = availablevechicle;
}

public AvailabeVechileDto() {
	super();
}

public Customer getC() {
	return c;
}

public void setC(Customer c) {
	this.c = c;
}

public double getDistance() {
	return distance;
}

public void setDistance(double distance) {
	this.distance = distance;
}

public String getSourceLocation() {
	return sourceLocation;
}

public void setSourceLocation(String sourceLocation) {
	this.sourceLocation = sourceLocation;
}

public String getDestinationLocation() {
	return DestinationLocation;
}

public void setDestinationLocation(String destinationLocation) {
	DestinationLocation = destinationLocation;
}

public List<VechileDetails> getAvailablevechicle() {
	return availablevechicle;
}

public void setAvailablevechicle(List<VechileDetails> availablevechicle) {
	this.availablevechicle = availablevechicle;
}

 
}
