package com.company.model;

public class User {
    String name;
    String surname;
    Role role;


    public enum Role {
        ADMIN,
        USER
    }

    public User(String name, String surname, Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

}
