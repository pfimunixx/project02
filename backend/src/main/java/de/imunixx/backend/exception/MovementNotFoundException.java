package de.imunixx.backend.exception;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String message){
        super(message);
    }
    
}
