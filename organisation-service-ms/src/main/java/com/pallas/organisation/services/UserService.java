package com.pallas.organisation.services;

import com.pallas.organisation.models.RequestAddUserDTO;
import com.pallas.organisation.models.RequestSignupDTO;
import com.pallas.organisation.models.ResponseUserDTO;
import com.pallas.organisation.models.ResponseUserRoleDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

public interface UserService {

    void signup(RequestSignupDTO requestSignupDTO);
    void addNewUserToTeam(RequestAddUserDTO requestAddUserDTO, UsernamePasswordAuthenticationToken authentication);
    List<ResponseUserDTO> getUsers(UsernamePasswordAuthenticationToken authenticationToken);
    ResponseUserDTO getUser(long id);
    ResponseUserRoleDTO validate(UsernamePasswordAuthenticationToken authenticationToken);

}
