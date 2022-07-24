package com.pallas.organisation.repositories;

import com.pallas.organisation.entities.Organisation;
import com.pallas.organisation.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findAllByOrganisation(Organisation organisation);
}
