package com.pallas.organisation.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public class RequestAddUserDTO {

    @Size(min = 2, message = "Min 2 character")
    @Size(max = 20, message = "Max 20 character")
    @NotBlank(message = "Name cannot be null")
    private String name;
    @Size(min = 2, message = "Min 2 character")
    @Size(max = 20, message = "Max 20 character")
    @NotBlank(message = "Surname cannot be null")
    private String surname;
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Please provide valid email")
    private String email;

    public String getName() {
        return name;
    }

    public RequestAddUserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RequestAddUserDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RequestAddUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
