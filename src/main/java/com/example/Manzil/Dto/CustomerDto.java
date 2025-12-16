package com.example.Manzil.Dto;

public class CustomerDto {
 private String name;
 private int age;
 private String gender;
 private long mob;
 private String email;
 private double latitude;
 private double longitude;
 
 public CustomerDto() {
	super();
 }

 public CustomerDto(String name, int age, String gender, long mob, String email, double latitude, double longitude) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.mob = mob;
	this.email = email;
	this.latitude = latitude;
	this.longitude = longitude;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public int getAge() {
	return age;
 }

 public void setAge(int age) {
	this.age = age;
 }

 public String getGender() {
	return gender;
 }

 public void setGender(String gender) {
	this.gender = gender;
 }

 public long getMob() {
	return mob;
 }

 public void setMob(long mob) {
	this.mob = mob;
 }

 public String getEmail() {
	return email;
 }

 public void setEmail(String email) {
	this.email = email;
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
 
 
 
 
 
}