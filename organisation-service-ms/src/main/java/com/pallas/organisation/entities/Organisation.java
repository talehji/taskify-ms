package com.pallas.organisation.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organisation {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phone;
    @Column(length = 250)
    private String address;
    @OneToMany(mappedBy = "organisation")
    private List<User> users;

    public Organisation() {
    }

    public long getId() {
        return id;
    }

    public Organisation setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organisation setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Organisation setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Organisation setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Organisation setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}
