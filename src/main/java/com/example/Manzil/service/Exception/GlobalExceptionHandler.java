package com.example.Manzil.service.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Manzil.responcestucture;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DriverNotFoundException.class)
    public responcestucture<String> handleDriverNotFound() {

        responcestucture<String> rs = new responcestucture<>();

        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMasg("Driver not found");
        rs.setData("Driver not found");

        return rs;
    }

    @ExceptionHandler(DriverAlreadyExistsException.class)
    public responcestucture<String> handleDriverExists() {

        responcestucture<String> rs = new responcestucture<>();

        rs.setStatuscode(HttpStatus.CONFLICT.value());
        rs.setMasg("Driver already exists");
        rs.setData("Driver already exists with this license number");

        return rs;
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public responcestucture<String> handleSQLConflict(DataIntegrityViolationException ex) {

        responcestucture<String> rs = new responcestucture<>();

        rs.setStatuscode(HttpStatus.CONFLICT.value());
        rs.setMasg("Database error occurred");
        rs.setData(ex.getCause().getMessage());

        return rs;
    }
    @ExceptionHandler(Exception.class)
    public responcestucture<String> handleAllExceptions(Exception ex) {

        responcestucture<String> rs = new responcestucture<>();

        rs.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        rs.setMasg("Unexpected error occurred");
        rs.setData(ex.getMessage());

        return rs;
    }

}
