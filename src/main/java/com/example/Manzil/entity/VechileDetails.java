package com.example.Manzil.entity;

public class VechileDetails {
private Vehicle v;
private double fare;
private String estimatedtimerequired;
private Driver driver;
public VechileDetails(Vehicle v, double fare, String estimatedtimerequired, Driver driver) {
	super();
	this.v = v;
	this.fare = fare;
	this.estimatedtimerequired = estimatedtimerequired;
	this.driver = driver;
}
public VechileDetails() {
	super();
}
public Vehicle getV() {
	return v;
}
public void setV(Vehicle v) {
	this.v = v;
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
public Driver getDriver() {
	return driver;
}
public void setDriver(Driver driver) {
	this.driver = driver;
}


}
