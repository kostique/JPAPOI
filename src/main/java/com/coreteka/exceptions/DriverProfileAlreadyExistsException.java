package com.coreteka.exceptions;

public class DriverProfileAlreadyExistsException extends RuntimeException {
    public DriverProfileAlreadyExistsException(String message) {
        super(message);
    }
}
