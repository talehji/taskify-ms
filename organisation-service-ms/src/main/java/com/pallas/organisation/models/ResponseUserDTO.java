package com.pallas.organisation.models;

public class ResponseUserDTO {

    private long id;
    private String name;
    private String surname;
    private String email;

    public long getId() {
        return id;
    }

    public ResponseUserDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseUserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ResponseUserDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResponseUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
