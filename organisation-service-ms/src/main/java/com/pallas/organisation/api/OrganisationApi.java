package com.pallas.organisation.api;

import com.pallas.organisation.services.OrganisationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisation/api/v1/organisation")
public class OrganisationApi {

    private final OrganisationService organisationService;

    public OrganisationApi(OrganisationService organisationService)  {
        this.organisationService = organisationService;
    }

    @GetMapping("/get/my")
    public ResponseEntity<?> getMyOrganisation(UsernamePasswordAuthenticationToken authentication) {
        return ResponseEntity.ok().body(organisationService.getMyOrganisation(authentication));
    }
}
