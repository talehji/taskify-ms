package com.pallas.organisation.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
