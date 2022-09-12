package com.digitoryproject.moviesservice.controllers;

import com.digitoryproject.moviesservice.entities.AppUser;
import com.digitoryproject.moviesservice.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class AppUserController {
    @Autowired
    AppUserService appUserService;


    @GetMapping("/allusers")
    public List<AppUser> returnUsers(){

        return appUserService.returnUsers();
    }

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

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id){
        appUserService.deleteUser(id);

    }

    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user) {
        return appUserService.login(user);
    }





}
