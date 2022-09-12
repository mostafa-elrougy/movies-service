package com.digitoryproject.moviesservice.controllers;

import com.digitoryproject.moviesservice.entities.Movie;
import com.digitoryproject.moviesservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

    }

    @GetMapping("/getmovies")
    public List<Movie> getMovies(){

        return movieService.getMovies();
    }

    @DeleteMapping("/deletemovie/{id}")
    public void deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);

    }

    @GetMapping("/findbycategory/{category}")
        public List<Movie> findByCategory(@PathVariable String category ) {

            return movieService.findByCategory(category);
        }


}
