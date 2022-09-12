package com.digitoryproject.moviesservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {



    @Id
    @GeneratedValue
    private Integer movieId;
    private String movieName;
    private String directorName;
    private String movieDuration;
    private String movieProductionYear;
    private String movieCategory;
    private String movieImageUrl;
    private String movieRating;
    private String movieDescription;
    private String movieVideoUrl;

//    @ManyToMany(mappedBy = "actorMovies")
//    private List<Actor> actors = new ArrayList<>();

//    public void setMovieId(Integer movieId) {
//        this.movieId = movieId;
//    }

//    public List<Actor> getActors() {
//        return actors;
//    }
//
//    public void setActors(List<Actor> actors) {
//        this.actors = actors;
//    }

//    public Movie() {
//
//    }
//
//    public Movie(Integer movieId, String movieName, String directorName,
//                 String movieDuration, String movieProductionYear,
//                 String movieCategory, String movieImageUrl,
//                 String movieRating, String movieDescription, String movieVideoUrl) {
//        this.movieId = movieId;
//        this.movieName = movieName;
//        this.directorName = directorName;
//        this.movieDuration = movieDuration;
//        this.movieProductionYear = movieProductionYear;
//        this.movieCategory = movieCategory;
//        this.movieImageUrl = movieImageUrl;
//        this.movieRating = movieRating;
//        this.movieDescription = movieDescription;
//        this.movieVideoUrl = movieVideoUrl;
//    }

    public Integer getMovieId() {

        return movieId;
    }

    public void setMovieId(Integer movieId) {

        this.movieId = movieId;
    }

    public String getMovieName() {

        return movieName;
    }

    public void setMovieName(String movieName) {

        this.movieName = movieName;
    }

    public String getDirectorName() {

        return directorName;
    }

    public void setDirectorName(String directorName) {

        this.directorName = directorName;
    }

    public String getMovieDuration() {

        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {

        this.movieDuration = movieDuration;
    }

    public String getMovieProductionYear() {

        return movieProductionYear;
    }

    public void setMovieProductionYear(String movieProductionYear) {
        this.movieProductionYear = movieProductionYear;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieVideoUrl() {
        return movieVideoUrl;
    }

    public void setMovieVideoUrl(String movieVideoUrl) {
        this.movieVideoUrl = movieVideoUrl;
    }
}
//    Movies entity ( id - name - director - time - year - category - image - rating - description - video )
//    Actors entity (id - name - image - moviesList)