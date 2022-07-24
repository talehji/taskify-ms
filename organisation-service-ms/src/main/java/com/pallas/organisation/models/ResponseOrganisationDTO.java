package com.pallas.organisation.models;

public class ResponseOrganisationDTO {

    private long id;
    private String name;
    private String phone;
    private String address;

    public long getId() {
        return id;
    }

    public ResponseOrganisationDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseOrganisationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ResponseOrganisationDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ResponseOrganisationDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
