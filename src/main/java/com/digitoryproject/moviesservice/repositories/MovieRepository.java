package com.digitoryproject.moviesservice.repositories;

import com.digitoryproject.moviesservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie> findByMovieCategory(String category);

    List<Movie> findMoviesByMovieIdIn(List<Integer> moviesIds);

    List<Movie> findMoviesByMovieNameContains(String word);

}
