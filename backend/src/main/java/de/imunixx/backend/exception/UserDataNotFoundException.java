package de.imunixx.backend.exception;

public class UserDataNotFoundException extends RuntimeException {
    public UserDataNotFoundException(String message){
        super(message);
    }
}
