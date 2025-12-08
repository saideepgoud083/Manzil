package com.example.Manzil.Dto;

public class BookVeichleDto {

	private long custmob;
	private long drivermobno;
	private String destinationlocation;
	public BookVeichleDto(long custmob, long drivermobno, String destinationlocation) {
		super();
		this.custmob = custmob;
		this.drivermobno = drivermobno;
		this.destinationlocation = destinationlocation;
	}
	public BookVeichleDto() {
		super();
	}
	public long getCustmob() {
		return custmob;
	}
	public void setCustmob(long custmob) {
		this.custmob = custmob;
	}
	public long getDrivermobno() {
		return drivermobno;
	}
	public void setDrivermobno(long drivermobno) {
		this.drivermobno = drivermobno;
	}
	public String getDestinationlocation() {
		return destinationlocation;
	}
	public void setDestinationlocation(String destinationlocation) {
		this.destinationlocation = destinationlocation;
	}
	
	
}
