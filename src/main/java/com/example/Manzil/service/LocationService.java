package com.example.Manzil.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Manzil.service.Exception.InvalidLocation;

@Service
public class LocationService {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public String getLocation(double lat, double lon) {
//
//        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lon;
//
//        Map response = restTemplate.getForObject(url, Map.class);
//
//        if (response != null && response.get("display_name") != null) {
//            return response.get("display_name").toString();
//        }
//
//        throw new InvalidLocation("Invalid latitude or longitude");
//    }
//	
//	@Service
//	public class LocationService {

	    @Autowired
	    private RestTemplate restTemplate;

	    public String getCity(double lat, double lon) {

	        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lon;

	        Map response = restTemplate.getForObject(url, Map.class);

	        if (response != null && response.get("address") != null) {

	            Map address = (Map) response.get("address");

	            if (address.get("city") != null) {
	                return address.get("city").toString();
	            }
	            if (address.get("town") != null) {
	                return address.get("town").toString();
	            }
	            if (address.get("village") != null) {
	                return address.get("village").toString();
	            }
	        }
     
	        throw new InvalidLocation("City not found for given location!");
	    }
	}



