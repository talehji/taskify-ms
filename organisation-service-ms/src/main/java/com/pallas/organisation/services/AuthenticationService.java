package com.pallas.organisation.services;

import com.pallas.organisation.models.ResponseUserDTO;
import com.pallas.organisation.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {

    User getUser(UsernamePasswordAuthenticationToken authentication);
    ResponseUserDTO getMyUser(UsernamePasswordAuthenticationToken authentication);
}
