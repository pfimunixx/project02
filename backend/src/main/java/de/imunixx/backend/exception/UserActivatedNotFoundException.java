package de.imunixx.backend.exception;

public class UserActivatedNotFoundException extends RuntimeException {
    public UserActivatedNotFoundException(String message){
        super(message);
    }
}
