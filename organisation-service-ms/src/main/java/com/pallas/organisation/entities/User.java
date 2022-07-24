package com.pallas.organisation.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean admin; // not necessary because of role, but added in case of need

    @ManyToOne
    @JoinColumn(name = "id_organisation", referencedColumnName = "id")
    private Organisation organisation;

    @ManyToMany(fetch = EAGER)
    private List<Role> roles = new ArrayList<>();


    public User() {
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isAdmin() {
        return admin;
    }

    public User setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public User setOrganisation(Organisation organisation) {
        this.organisation = organisation;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public User addRole(Role role){
        this.roles.add(role);
        return this;
    }
}
