package com.pallas.organisation.repositories;

import com.pallas.organisation.entities.Organisation;
import org.springframework.data.repository.CrudRepository;

public interface OrganisationRepository extends CrudRepository<Organisation, Long> {
}
