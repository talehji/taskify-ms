package com.pallas.organisation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }
}
