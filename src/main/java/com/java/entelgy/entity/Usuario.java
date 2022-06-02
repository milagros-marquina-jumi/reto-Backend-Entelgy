package com.java.entelgy.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Usuario {

    private Integer id;
    private String email;
    private String lastName;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", email='" + getEmail() + "'" +
                ", lastName='" + getLastName() + "'" +
                "}";
    }

}