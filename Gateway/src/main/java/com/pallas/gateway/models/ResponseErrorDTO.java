package com.pallas.gateway.models;

public class ResponseErrorDTO {

    private String message;

    public String getMessage() {
        return message;
    }

    public ResponseErrorDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
