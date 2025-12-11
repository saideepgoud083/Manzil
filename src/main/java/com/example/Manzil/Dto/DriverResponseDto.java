package com.example.Manzil.Dto;

public class DriverResponseDto {
	 private int driverId;
	    private String driverName;
	    private long mobileNum;
	    private String vehicleName;
	    private String vehicleNum;
	    private String vehicleType;
		public DriverResponseDto(int driverId, String driverName, long mobileNum, String vehicleName, String vehicleNum,
				String vehicleType) {
			super();
			this.driverId = driverId;
			this.driverName = driverName;
			this.mobileNum = mobileNum;
			this.vehicleName = vehicleName;
			this.vehicleNum = vehicleNum;
			this.vehicleType = vehicleType;
		}
		public DriverResponseDto() {
			super();
		}
		public int getDriverId() {
			return driverId;
		}
		public void setDriverId(int driverId) {
			this.driverId = driverId;
		}
		public String getDriverName() {
			return driverName;
		}
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public long getMobileNum() {
			return mobileNum;
		}
		public void setMobileNum(long mobileNum) {
			this.mobileNum = mobileNum;
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
	    
	    
	
	
}
