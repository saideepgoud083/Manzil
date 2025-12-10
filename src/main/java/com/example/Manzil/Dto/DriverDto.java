package com.example.Manzil.Dto;

public class DriverDto {

	private String licenseNum;
	
	private String upiId;
	
	private String driverName;
	
	private int age;
	
	private long mobNum;
	
	private String gender;
	
	private String mailId;
	
	private String vehicleName;
	
	private String vehicleNum;
	
	private String vehicleType;
	
	private String vehicleModel;
	
	private int capacity;
	
	private double averageSpeed;
	
	private double latitude;
	
	private double longitude;
	
	private double pricePerKm;

	public DriverDto() {
		super();
	}

	public DriverDto(String licenseNum, String upiId, String driverName, int age, long mobNum, String gender,
			String mailId, String vehicleName, String vehicleNum, String vehicleType, String vehicleModel, int capacity,double averageSpeed,
			double latitude, double longitude, double pricePerKm) {
		super();
		this.licenseNum = licenseNum;
		this.upiId = upiId;
		this.driverName = driverName;
		this.age = age;
		this.mobNum = mobNum;
		this.gender = gender;
		this.mailId = mailId;
		this.vehicleName = vehicleName;
		this.vehicleNum = vehicleNum;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.capacity = capacity;
		this.averageSpeed=averageSpeed;
		this.latitude = latitude;
		this.longitude = longitude;
		this.pricePerKm = pricePerKm;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobNum() {
		return mobNum;
	}

	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getCapacity() {
		return capacity;
	}
	

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(double pricePerKm) {
		this.pricePerKm = pricePerKm;
	}


	
	
	
	
	
	
	
	
	
	
	
}