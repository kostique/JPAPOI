package com.coreteka.exceptions;

public class TripWasNotFoundExeption extends RuntimeException {
    public TripWasNotFoundExeption(String message) {
        super(message);
    }
}
