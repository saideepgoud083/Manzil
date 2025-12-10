package com.example.Manzil.Dto;

import com.example.Manzil.entity.Vehicle;
	
	public class BookingDto {
	
		private Vehicle v;
		private String sourcelocation;
	
		private String destinationlocation;
		
		private double fare;
		
		private double distancetravelled;
		private String estimatedtime;
		public BookingDto(Vehicle v, String sourcelocation, String destinationlocation, double fare,
				double distancetravelled, String estimatedtime) {
			super();
			this.v = v;
			this.sourcelocation = sourcelocation;
			this.destinationlocation = destinationlocation;
			this.fare = fare;
			this.distancetravelled = distancetravelled;
			this.estimatedtime = estimatedtime;
		}
		public BookingDto() {
			super();
		}
		public Vehicle getV() {
			return v;
		}
		public void setV(Vehicle v) {
			this.v = v;
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
		public double getFare() {
			return fare;
		}
		public void setFare(double fare) {
			this.fare = fare;
		}
		public double getDistancetravelled() {
			return distancetravelled;
		}
		public void setDistancetravelled(double distancetravelled) {
			this.distancetravelled = distancetravelled;
		}
		public String getEstimatedtime() {
			return estimatedtime;
		}
		public void setEstimatedtime(String estimatedtime) {
			this.estimatedtime = estimatedtime;
		}
		
		
		
	}
