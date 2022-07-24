package com.pallas.gateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AuthenticationErrorException extends ResponseStatusException {

    public AuthenticationErrorException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
