package com.pallas.task.client.models;

public class OrganisationDTO {

    private long id;
    private String name;
    private String phone;
    private String address;

    public long getId() {
        return id;
    }

    public OrganisationDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrganisationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OrganisationDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrganisationDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
