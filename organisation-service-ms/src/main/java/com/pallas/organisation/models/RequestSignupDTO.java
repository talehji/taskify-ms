package com.pallas.organisation.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public class RequestSignupDTO {

    @Size(min = 2, message = "Min 2 character")
    @Size(max = 20, message = "Max 20 character")
    @NotBlank(message = "Organisation name cannot be null")
    private String organisationName;
    @Size(min = 2, message = "Min 2 character")
    @Size(max = 14, message = "Max 14 character") // random size
    @NotBlank(message = "Phone cannot be null")
    private String phone;
    @Size(min = 2, message = "Min 2 character")
    @Size(max = 200, message = "Max 200 character")
    @NotBlank(message = "Address cannot be null")
    private String address;
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
    @Size(min = 6, message = "Min 6 character")
    @Size(max = 12, message = "Max 12 character")
    @NotBlank(message = "Password cannot be null")
    private String password;

    public String getOrganisationName() {
        return organisationName;
    }

    public RequestSignupDTO setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RequestSignupDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RequestSignupDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public RequestSignupDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RequestSignupDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RequestSignupDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequestSignupDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
