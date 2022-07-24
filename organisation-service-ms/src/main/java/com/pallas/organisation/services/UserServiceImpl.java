package com.pallas.organisation.services;

import com.pallas.organisation.models.RequestAddUserDTO;
import com.pallas.organisation.models.RequestSignupDTO;
import com.pallas.organisation.models.ResponseUserDTO;
import com.pallas.organisation.models.ResponseUserRoleDTO;
import com.pallas.organisation.entities.Organisation;
import com.pallas.organisation.entities.Role;
import com.pallas.organisation.entities.User;
import com.pallas.organisation.repositories.RoleRepository;
import com.pallas.organisation.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final OrganisationService organisationService;
    private final AuthenticationService authenticationService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, OrganisationService organisationService, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.organisationService = organisationService;
        this.authenticationService = authenticationService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    user.get().getEmail(),
                    user.get().getPassword(),
                    user.get().getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public void signup(RequestSignupDTO requestSignupDTO) {
        Organisation organisation = organisationService.save(new Organisation()
                .setName(requestSignupDTO.getOrganisationName())
                .setPhone(requestSignupDTO.getPhone())
                .setAddress(requestSignupDTO.getAddress())
        );

        userRepository.save(new User()
                .setName(requestSignupDTO.getName())
                .setSurname(requestSignupDTO.getSurname())
                .setEmail(requestSignupDTO.getEmail())
                .setPassword(passwordEncoder.encode(requestSignupDTO.getPassword()))
                .setAdmin(true)
                .setOrganisation(organisation)
                .addRole(getRoleByName("ROLE_ADMIN")));
    }

    @Override
    public void addNewUserToTeam(RequestAddUserDTO requestAddUserDTO, UsernamePasswordAuthenticationToken authentication) {
        User myUser = authenticationService.getUser(authentication);
        userRepository.save(new User()
                .setName(requestAddUserDTO.getName())
                .setSurname(requestAddUserDTO.getSurname())
                .setEmail(requestAddUserDTO.getEmail())
                .setPassword(passwordEncoder.encode("12345678"))
                .setAdmin(false)
                .setOrganisation(myUser.getOrganisation())
                .addRole(getRoleByName("ROLE_USER"))
        );
    }

    @Override
    public List<ResponseUserDTO> getUsers(UsernamePasswordAuthenticationToken authenticationToken) {
        User myUser = authenticationService.getUser(authenticationToken);
        List<User> users = userRepository.findAllByOrganisation(myUser.getOrganisation());
        return users.stream()
                .map(user -> new ResponseUserDTO()
                        .setId(user.getId())
                        .setName(user.getName())
                        .setSurname(user.getSurname())
                        .setEmail(user.getEmail())
                ).collect(Collectors.toList());
    }

    @Override
    public ResponseUserDTO getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return new ResponseUserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail());
    }

    @Override
    public ResponseUserRoleDTO validate(UsernamePasswordAuthenticationToken authenticationToken) {
        User user = authenticationService.getUser(authenticationToken);
        return new ResponseUserRoleDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setAdmin(user.isAdmin())
                .setRoles(user.getRoles());
    }

    private Role getRoleByName(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseGet(() -> roleRepository.save(new Role().setName(roleName)));
    }
}
