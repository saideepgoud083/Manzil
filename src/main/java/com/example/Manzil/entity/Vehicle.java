package com.example.Manzil.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@JsonIgnoreProperties({"d"})
@Entity
public class Vehicle {
	@Id
	private int vehicleId;
	private String vehicleName;
	private String vehicleNum;
	
	private String type;
	
	private String model;
	
	private int capacity;
	
	private double averageSpeed;
	
	private String currentCity;
	
	private String availabilityStatus;
	
	private double pricePerKm;

	

	@JsonIgnoreProperties({"d"})
	@OneToOne
	@MapsId
	@JsonBackReference
	@JoinColumn(name = "vehicle_id")	
	private Driver d ;

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, String vehicleName, String vehicleNum, String type, String model, int capacity, double averageSpeed,
			String currentCity, String availabilityStatus, double pricePerKm, Driver d) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleNum = vehicleNum;
		this.type = type;
		this.model = model;
		this.capacity = capacity;
		this.averageSpeed=averageSpeed;
		this.currentCity = currentCity;
		this.availabilityStatus = availabilityStatus;
		this.pricePerKm = pricePerKm;
		this.d = d;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public double getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(double pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	public Driver getD() {
		return d;
	}

	public void setD(Driver d) {
		this.d = d;
	}
//
//	@Override
//	public String toString() {
//		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleNum=" + vehicleNum
//				+ ", type=" + type + ", model=" + model + ", capacity=" + capacity + ", averageSpeed=" + averageSpeed
//				+ ", currentCity=" + currentCity + ", availabilityStatus=" + availabilityStatus + ", pricePerKm="
//				+ pricePerKm + ", d=" + d + "]";
//	}

	
	
	
	

}