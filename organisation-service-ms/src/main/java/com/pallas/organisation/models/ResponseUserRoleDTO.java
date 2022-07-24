package com.pallas.organisation.models;

import com.pallas.organisation.entities.Role;

import java.util.List;

public class ResponseUserRoleDTO {

    private long id;
    private String name;
    private String surname;
    private String email;
    private boolean admin;
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public ResponseUserRoleDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseUserRoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ResponseUserRoleDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResponseUserRoleDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isAdmin() {
        return admin;
    }

    public ResponseUserRoleDTO setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public ResponseUserRoleDTO setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
