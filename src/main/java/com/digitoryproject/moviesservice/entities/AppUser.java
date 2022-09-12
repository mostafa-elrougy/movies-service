package com.digitoryproject.moviesservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class AppUser  {

    @Id
    @GeneratedValue
    private Integer Id;

    private String username;
    private String email;
    private String password;

//    private boolean isSuccessfullyLogged= false;

//    public boolean isSuccessfullyLogged() {
//        return isSuccessfullyLogged;
//    }
//
//    public void setSuccessfullyLogged(boolean successfullyLogged) {
//        isSuccessfullyLogged = successfullyLogged;
//    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
