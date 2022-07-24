package com.pallas.organisation.api;

import com.pallas.organisation.models.RequestAddUserDTO;
import com.pallas.organisation.models.RequestSignupDTO;
import com.pallas.organisation.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organisation/api/v1/user")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RequestSignupDTO requestSignupDTO){
        userService.signup(requestSignupDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody RequestAddUserDTO requestAddUserDTO, UsernamePasswordAuthenticationToken authentication){
        userService.addNewUserToTeam(requestAddUserDTO, authentication);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(UsernamePasswordAuthenticationToken authentication){
        return ResponseEntity.ok().body(userService.getUsers(authentication));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(UsernamePasswordAuthenticationToken authentication){
        return ResponseEntity.ok().body(userService.validate(authentication));
    }
}
