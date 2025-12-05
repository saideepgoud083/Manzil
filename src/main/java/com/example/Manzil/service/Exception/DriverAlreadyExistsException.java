package com.example.Manzil.service.Exception;

public class DriverAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DriverAlreadyExistsException() {
        super("Driver already exists with this license number");
    }
}
