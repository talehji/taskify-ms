package com.pallas.organisation.services;

import com.pallas.organisation.models.ResponseOrganisationDTO;
import com.pallas.organisation.entities.Organisation;
import com.pallas.organisation.entities.User;
import com.pallas.organisation.repositories.OrganisationRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;
    private final AuthenticationService authenticationService;

    public OrganisationServiceImpl(OrganisationRepository organisationRepository, AuthenticationService authenticationService) {
        this.organisationRepository = organisationRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseOrganisationDTO getMyOrganisation(UsernamePasswordAuthenticationToken authenticationToken) {
        User user = authenticationService.getUser(authenticationToken);
        return new ResponseOrganisationDTO()
                .setId(user.getOrganisation().getId())
                .setName(user.getOrganisation().getName())
                .setPhone(user.getOrganisation().getPhone())
                .setAddress(user.getOrganisation().getAddress());
    }

    @Override
    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }
}
