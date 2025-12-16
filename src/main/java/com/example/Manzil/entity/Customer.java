package com.example.Manzil.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 private String name;
 private int age;
 private String gender;
 private long mob;
 private String emailid;
 private String currentLocation;
 private boolean flag ;
 private String rollbackvarivle = "customer";
 
 private int panality =0;
 

 @OneToMany(mappedBy="cust", cascade=CascadeType.ALL)
 @JsonIgnore   
 private List<Booking> blist;


 public Customer() {
	super();
}


 public Customer(String name, int age, String gender, long mob, String emailid, String currentLocation, boolean flag,
		String rollbackvarivle, int panality, List<Booking> blist) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.mob = mob;
	this.emailid = emailid;
	this.currentLocation = currentLocation;
	this.flag = flag;
	this.rollbackvarivle = rollbackvarivle;
	this.panality = panality;
	this.blist = blist;
 }


 public int getId() {
	return id;
 }


 public void setId(int id) {
	this.id = id;
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


 public String getEmailid() {
	return emailid;
 }


 public void setEmailid(String emailid) {
	this.emailid = emailid;
 }


 public String getCurrentLocation() {
	return currentLocation;
 }


 public void setCurrentLocation(String currentLocation) {
	this.currentLocation = currentLocation;
 }


 public boolean isFlag() {
	return flag;
 }


 public void setFlag(boolean flag) {
	this.flag = flag;
 }


 public String getRollbackvarivle() {
	return rollbackvarivle;
 }


 public void setRollbackvarivle(String rollbackvarivle) {
	this.rollbackvarivle = rollbackvarivle;
 }


 public int getPanality() {
	return panality;
 }


 public void setPanality(int panality) {
	this.panality = panality;
 }


 public List<Booking> getBlist() {
	return blist;
 }


 public void setBlist(List<Booking> blist) {
	this.blist = blist;
 }
 

 

 
}
