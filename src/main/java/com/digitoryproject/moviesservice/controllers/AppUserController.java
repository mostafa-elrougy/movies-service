package com.digitoryproject.moviesservice.controllers;

import com.digitoryproject.moviesservice.entities.AppUser;
import com.digitoryproject.moviesservice.entities.Movie;
import com.digitoryproject.moviesservice.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Users")
public class AppUserController {
    @Autowired
    AppUserService appUserService;


    @GetMapping("/allusers")
    public List<AppUser> returnUsers(){

        return appUserService.returnUsers();
    }

//    @CrossOrigin
    @PostMapping("/register")
    public void addUser(@RequestBody AppUser user){
        appUserService.addUser(user);
    }

//    @PostMapping("/register")
//    public void register(@RequestParam("username") String username,
//                         @RequestParam("email") String email,
//                         @RequestParam("password") String password ){
//        appUserService.register(username,email,password);
//    }

//    @CrossOrigin
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id){
        appUserService.deleteUser(id);

    }

//    @CrossOrigin
    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user) {
        return appUserService.login(user);
    }

    @CrossOrigin
    @GetMapping("/getfavourites/{userId}")
    public List<Movie> getFavourites(@PathVariable Integer userId){

        return appUserService.getFavourites(userId);

    }

    @CrossOrigin
    @PostMapping("addtofavourites/{userId}/{movieId}")
    public void addToFavourites(@PathVariable("userId") Integer userId,@PathVariable("movieId") Integer movieId) {
        appUserService.addToFavourites(userId, movieId);

    }
    @CrossOrigin
    @DeleteMapping("/removefavourite/{userId}/{movieId}")
    public void removeFavourites(@PathVariable Integer userId,@PathVariable Integer movieId) {
        appUserService.removeFavourites(userId,movieId);
    }
    }
