package com.digitoryproject.moviesservice.services;

import com.digitoryproject.moviesservice.entities.Movie;
import com.digitoryproject.moviesservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.save(movie);

    }

    public void addMovies(List<Movie> movies){
        movieRepository.saveAll(movies);

    }



    public void deleteMovie(int id){
        movieRepository.deleteById(id);

    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> findByCategory(String category) {
        // TODO Auto-generated method stub
        return movieRepository.findByMovieCategory(category);
    }


}
