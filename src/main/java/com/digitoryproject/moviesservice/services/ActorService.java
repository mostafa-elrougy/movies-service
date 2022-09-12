package com.digitoryproject.moviesservice.services;

import com.digitoryproject.moviesservice.entities.Actor;
import com.digitoryproject.moviesservice.entities.Movie;
import com.digitoryproject.moviesservice.repositories.ActorRepository;
import com.digitoryproject.moviesservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addActor(Actor actor){
        List<Integer> moviesIds = actor.getActorMovies().stream().map(Movie::getMovieId).toList();
        List<Movie> movies = movieRepository.findMoviesByMovieIdIn(moviesIds);
        actor.setActorMovies(movies);
        actorRepository.save(actor);
    }

    public Actor getActor(int id){
        return actorRepository.findById(id).get();

    }



}
