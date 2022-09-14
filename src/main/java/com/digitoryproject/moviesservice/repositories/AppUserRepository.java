package com.digitoryproject.moviesservice.repositories;

import com.digitoryproject.moviesservice.entities.AppUser;
import com.digitoryproject.moviesservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);

//    List<Movie> findUserFavourites(Integer Id);


    //AppUser findByUsername(String username);
}


