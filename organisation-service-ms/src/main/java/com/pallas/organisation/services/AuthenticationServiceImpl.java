package com.pallas.organisation.services;

import com.pallas.organisation.models.ResponseUserDTO;
import com.pallas.organisation.entities.User;
import com.pallas.organisation.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(UsernamePasswordAuthenticationToken authentication) {
        return userRepository.findByEmail(authentication.getPrincipal().toString())
                .orElseThrow(() -> new UsernameNotFoundException("Authentication error"));
    }

    @Override
    public ResponseUserDTO getMyUser(UsernamePasswordAuthenticationToken authentication) {
        User user = userRepository.findByEmail(authentication.getPrincipal().toString())
                .orElseThrow(() -> new UsernameNotFoundException("Authentication error"));
        return new ResponseUserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail());
    }
}
