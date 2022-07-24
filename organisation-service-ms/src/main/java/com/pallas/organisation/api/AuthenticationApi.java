package com.pallas.organisation.api;

import com.pallas.organisation.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisation/api/v1/authentication")
public class AuthenticationApi {

    private final AuthenticationService authenticationService;

    public AuthenticationApi(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/get/me")
    public ResponseEntity<?> getMyUser(UsernamePasswordAuthenticationToken authentication){
        return ResponseEntity.ok().body(authenticationService.getMyUser(authentication));
    }
}
