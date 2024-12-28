package com.ust.Logistic_Domain.Exception;


public class ShipmentNotFoundException extends RuntimeException {
    public ShipmentNotFoundException(String message) {
        super(message);  // Pass the message to the superclass (RuntimeException)
    }
}
