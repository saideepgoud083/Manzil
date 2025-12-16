package com.example.Manzil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Booking booking ;
	@OneToOne
	private Vehicle v ;
	private double amount ;
	private String paymentype ;
	public Payment() {
		super();
	}
	public Payment(Customer customer, Booking booking, Vehicle v, double amount, String paymentype) {
		super();
		this.customer = customer;
		this.booking = booking;
		this.v = v;
		this.amount = amount;
		this.paymentype = paymentype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Vehicle getV() {
		return v;
	}
	public void setV(Vehicle v) {
		this.v = v;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentype() {
		return paymentype;
	}
	public void setPaymentype(String paymentype) {
		this.paymentype = paymentype;
	}
	
	
	
}
