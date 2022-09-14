package com.digitoryproject.moviesservice.services;

import com.digitoryproject.moviesservice.entities.AppUser;
import com.digitoryproject.moviesservice.entities.Movie;
import com.digitoryproject.moviesservice.repositories.AppUserRepository;
import com.digitoryproject.moviesservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    MovieRepository movieRepository;

    public void addUser(AppUser user) {
        if (appUserRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        } else if (appUserRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        } else {
            appUserRepository.save(user);
        }


    }

    public List<AppUser> returnUsers() {

        return appUserRepository.findAll();
    }


//    public void register(String username, String email, String password){
//        AppUser User = new AppUser();
//        User.setEmail(email);
//        User.setPassword(password);
//        User.setUsername(username);
//        appUserRepository.save(User);
//
//    }

    public void deleteUser(int id) {
        appUserRepository.deleteById(id);

    }

    public AppUser login(AppUser user) {
        Optional<AppUser> userMaybe = appUserRepository.findByEmail(user.getEmail());
        if (userMaybe.isPresent()) {
            AppUser checkedUser = userMaybe.get();
            if (checkedUser.getPassword().equals(user.getPassword())) {
//                     checkedUser.setSuccessfullyLogged(true);
                return checkedUser;
            } else
                throw new IllegalArgumentException("Incorrect Password");
        }
        throw new IllegalArgumentException("There's no user with this username.");
    }


    public List<Movie> getFavourites(Integer userId) {

        return appUserRepository.findById(userId).get().getUserFavourites();

    }

    public void removeFavourites(Integer userId, Integer movieId) {

        AppUser user = appUserRepository.findById(userId).get();
        List<Movie> userFavourites = user.getUserFavourites();
        Optional<Movie> favouriteMovieMaybe = userFavourites.stream()
                .filter(movie -> movie.getMovieId() == movieId)
                .findFirst();
        if (favouriteMovieMaybe.isPresent()) {
            Movie favouriteMovie = favouriteMovieMaybe.get();
            userFavourites.remove(favouriteMovie);
            user.setUserFavourites(userFavourites);
            appUserRepository.save(user);
        } else {
            throw new IllegalArgumentException("Movie is not in favourites");
        }

    }


//    public List<Movie> getFavourites(AppUser user){
//        List<Integer> moviesIds = user.getUserFavourites().stream().map(Movie::getMovieId).collect(Collectors.toList());
//        List<Movie> movies = movieRepository.findMoviesByMovieIdIn(moviesIds);
//        user.setUserFavourites(movies);
//        return user.getUserFavourites();
////        appUserRepository.save(actor);
//    }

    public void addToFavourites(Integer userId, Integer movieId) {
//            boolean foundMovie;
        Movie fav = movieRepository.findById(movieId).get();
        AppUser user = appUserRepository.findById(userId).get();
        for (Movie check : user.getUserFavourites()) {
            if (check.equals(fav)) {
//                    foundMovie=true;
                throw new IllegalArgumentException("Movie already in favourites");
            }
//            }else{
//            user.addToFavourites(fav);
//            appUserRepository.save(user);
//            }
//        List<Integer> moviesIds = user.getUserFavourites().stream().map(Movie::getMovieId).collect(Collectors.toList());
//        List<Movie> movies = movieRepository.findMoviesByMovieIdIn(moviesIds);
//        user.setUserFavourites(movies);
//        return user.getUserFavourites();
//        appUserRepository.save(actor);
        }
        user.addToFavourites(fav);
        appUserRepository.save(user);
    }


//    public void addToFavourites1(Integer userId, Integer movieId){
//        Movie fav= movieRepository.findById(movieId).get();
//        appUserRepository.findById(userId).get().getUserFavourites().add(fav);
//
//
//
////        List<Integer> moviesIds = user.getUserFavourites().stream().map(Movie::getMovieId).collect(Collectors.toList());
////        List<Movie> movies = movieRepository.findMoviesByMovieIdIn(moviesIds);
////        user.setUserFavourites(movies);
////        return user.getUserFavourites();
////        appUserRepository.save(actor);
//    }

}
