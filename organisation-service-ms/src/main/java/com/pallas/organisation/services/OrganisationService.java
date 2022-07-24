package com.pallas.organisation.services;

import com.pallas.organisation.models.ResponseOrganisationDTO;
import com.pallas.organisation.entities.Organisation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface OrganisationService {
    ResponseOrganisationDTO getMyOrganisation(UsernamePasswordAuthenticationToken authenticationToken);
    Organisation save(Organisation organisation);
}
