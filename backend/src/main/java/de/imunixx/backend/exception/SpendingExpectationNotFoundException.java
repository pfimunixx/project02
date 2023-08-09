package de.imunixx.backend.exception;

    public class SpendingExpectationNotFoundException extends RuntimeException {
        public SpendingExpectationNotFoundException(String message){
            super(message);
        }
    }
