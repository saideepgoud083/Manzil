package com.example.Manzil.service.Exception;

public class DriverNotFoundException extends RuntimeException {
	 private static final long serialVersionUID = 1L;

	    public DriverNotFoundException() {
	    	super("Driver not found");
	    }
}
