package com.digitoryproject.moviesservice.controllers;

import com.digitoryproject.moviesservice.entities.Actor;
import com.digitoryproject.moviesservice.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    @PostMapping("/addactor")
    public void addActor(@RequestBody Actor actor){
        actorService.addActor(actor);

    }
@GetMapping("/getactor/{id}")
    public Actor getActor(@PathVariable int id){
        return actorService.getActor(id);

    }
}
