package com.company.model;


public class User {
    String name;
    String surname;
    Role role;
    String login;
    String password;


    public enum Role {
        ADMIN,
        USER

    }

    public User(String name, String surname, Role role, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
