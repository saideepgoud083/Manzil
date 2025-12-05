package com.example.Manzil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@ManyToOne

	private Customer cust;

@ManyToOne

	private Driver driver;
	private String sourcelocation;
	private String destinationlocation;
	private double distancetravlled;
	private double fare;
	private String estimatedtimerequired;
	private String datebooked;
	@OneToOne
	private Payment payment;
	public Booking(int id, Customer cust, Driver driver, String sourcelocation, String destinationlocation,
			double distancetravlled, double fare, String estimatedtimerequired, String datebooked, Payment payment) {
		super();
		this.id = id;
		this.cust = cust;
		this.driver = driver;
		this.sourcelocation = sourcelocation;
		this.destinationlocation = destinationlocation;
		this.distancetravlled = distancetravlled;
		this.fare = fare;
		this.estimatedtimerequired = estimatedtimerequired;
		this.datebooked = datebooked;
		this.payment = payment;
	}
	public Booking() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getSourcelocation() {
		return sourcelocation;
	}
	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}
	public String getDestinationlocation() {
		return destinationlocation;
	}
	public void setDestinationlocation(String destinationlocation) {
		this.destinationlocation = destinationlocation;
	}
	public double getDistancetravlled() {
		return distancetravlled;
	}
	public void setDistancetravlled(double distancetravlled) {
		this.distancetravlled = distancetravlled;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getEstimatedtimerequired() {
		return estimatedtimerequired;
	}
	public void setEstimatedtimerequired(String estimatedtimerequired) {
		this.estimatedtimerequired = estimatedtimerequired;
	}
	public String getDatebooked() {
		return datebooked;
	}
	public void setDatebooked(String datebooked) {
		this.datebooked = datebooked;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", cust=" + cust + ", driver=" + driver + ", sourcelocation=" + sourcelocation
				+ ", destinationlocation=" + destinationlocation + ", distancetravlled=" + distancetravlled + ", fare="
				+ fare + ", estimatedtimerequired=" + estimatedtimerequired + ", datebooked=" + datebooked
				+ ", payment=" + payment + "]";
	}
	
	
}
