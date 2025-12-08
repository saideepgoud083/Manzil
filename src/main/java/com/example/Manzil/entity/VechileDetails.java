package com.example.Manzil.entity;

public class VechileDetails {
private Vehicle v;
private double fare;
private String estimatedtimerequired;
public VechileDetails(Vehicle v, double fare, String estimatedtimerequired) {
	super();
	this.v = v;
	this.fare = fare;
	this.estimatedtimerequired = estimatedtimerequired;
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
@Override
public String toString() {
	return "VechileDetails [v=" + v + ", fare=" + fare + ", estimatedtimerequired=" + estimatedtimerequired + "]";
}

}
