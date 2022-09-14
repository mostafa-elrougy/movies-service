package com.digitoryproject.moviesservice.entities;

import javax.persistence.*;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Entity
public class AppUser  {

    @Id
    @GeneratedValue
    private Integer Id;

    private String username;
    private String email;
    private String password;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "user_favourites",
            joinColumns = @JoinColumn(name = "Id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> userFavourites;



    public List<Movie> getUserFavourites() {
        return userFavourites;
    }

    public void setUserFavourites(List<Movie> userFavourites) {
        this.userFavourites = userFavourites;
    }

    public void addToFavourites(Movie userFavourite) {
        this.userFavourites.add(userFavourite) ;
    }
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

    public void setId(Integer userId) {
        this.Id = userId;
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
