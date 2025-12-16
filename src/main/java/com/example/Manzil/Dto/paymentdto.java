package com.example.Manzil.Dto;

import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Payment;
import com.example.Manzil.entity.Vehicle;

public class paymentdto {
private Customer c;
private Booking b;
private Vehicle v  ;
private Payment p ;
public paymentdto() {
	super();
}
public paymentdto(Customer c, Booking b, Vehicle v, Payment p) {
	super();
	this.c = c;
	this.b = b;
	this.v = v;
	this.p = p;
}
public Customer getC() {
	return c;
}
public void setC(Customer c) {
	this.c = c;
}
public Booking getB() {
	return b;
}
public void setB(Booking b) {
	this.b = b;
}
public Vehicle getV() {
	return v;
}
public void setV(Vehicle v) {
	this.v = v;
}
public Payment getP() {
	return p;
}
public void setP(Payment p) {
	this.p = p;
}


}
