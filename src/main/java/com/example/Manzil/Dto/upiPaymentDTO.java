package com.example.Manzil.Dto;

public class upiPaymentDTO {
private double fare;
private byte[] qr;
public upiPaymentDTO() {
	super();
}
public upiPaymentDTO(double fare, byte[] qr) {
	super();
	this.fare = fare;
	this.qr = qr;
}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}
public byte[] getQr() {
	return qr;
}
public void setQr(byte[] qr) {
	this.qr = qr;
}

}
