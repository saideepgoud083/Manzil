package com.example.Manzil.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Entity
public class Driver {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int driverId;

	    private String licenseNum;
	    private String upiId;
	    private String driverName;
	    private String driverStatus;
	    private int age ;
	    private long mobileNum ;
	    private String gender;
	    private String mailId;

//	    @OneToOne(cascade = CascadeType.ALL)
//	    @JoinColumn(name = "vehicle_id")
//	   
	    @OneToOne(cascade = CascadeType.ALL)
	    @JsonManagedReference          // <-- This side will be serialized
	    @JoinColumn(name = "vehicle_id")
	    private Vehicle v;
	    
	    @OneToMany( cascade = CascadeType.ALL)
	    private List<Booking> blist;

		public Driver(int driverId, String licenseNum, String upiId, String driverName, String driverStatus, int age,
				long mobileNum, String gender, String mailId, Vehicle v, List<Booking> blist) {
			super();
			this.driverId = driverId;
			this.licenseNum = licenseNum;
			this.upiId = upiId;
			this.driverName = driverName;
			this.driverStatus = driverStatus;
			this.age = age;
			this.mobileNum = mobileNum;
			this.gender = gender;
			this.mailId = mailId;
			this.v = v;
			this.blist = blist;
		}

		public Driver() {
			super();
		}

		public int getDriverId() {
			return driverId;
		}

		public void setDriverId(int driverId) {
			this.driverId = driverId;
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

		public String getDriverStatus() {
			return driverStatus;
		}

		public void setDriverStatus(String driverStatus) {
			this.driverStatus = driverStatus;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getMobileNum() {
			return mobileNum;
		}

		public void setMobileNum(long mobileNum) {
			this.mobileNum = mobileNum;
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

		public Vehicle getV() {
			return v;
		}

		public void setV(Vehicle v) {
			this.v = v;
		}

		public List<Booking> getBlist() {
			return blist;
		}

		public void setBlist(List<Booking> blist) {
			this.blist = blist;
		}

		@Override
		public String toString() {
			return "Driver [driverId=" + driverId + ", licenseNum=" + licenseNum + ", upiId=" + upiId + ", driverName="
					+ driverName + ", driverStatus=" + driverStatus + ", age=" + age + ", mobileNum=" + mobileNum
					+ ", gender=" + gender + ", mailId=" + mailId + ", v=" + v + ", blist=" + blist + "]";
		}

	
	
	
	

}