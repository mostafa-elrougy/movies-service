package com.digitoryproject.moviesservice.services;

import com.digitoryproject.moviesservice.entities.AppUser;
import com.digitoryproject.moviesservice.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService  {

    @Autowired
    AppUserRepository appUserRepository;

    public void addUser(AppUser user){
        if(appUserRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        } else if (appUserRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }else{
            appUserRepository.save(user);
        }




    }

    public List<AppUser> returnUsers(){

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

    public void deleteUser(int id){
        appUserRepository.deleteById(id);

    }

    public AppUser login(AppUser user) {
        Optional<AppUser> userMaybe = appUserRepository.findByEmail(user.getEmail());
        if(userMaybe.isPresent()){
                AppUser checkedUser =userMaybe.get();
                if(checkedUser.getPassword().equals(user.getPassword())){
//                     checkedUser.setSuccessfullyLogged(true);
                     return checkedUser;
                }
                else
                    throw new IllegalArgumentException("Incorrect Password");
        }
        throw new IllegalArgumentException("There's no user with this username.");
    }


}
