package com.digitoryproject.moviesservice.controllers;

import com.digitoryproject.moviesservice.entities.Actor;
import com.digitoryproject.moviesservice.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    @PostMapping("/addactor")
    public void addActor(@RequestBody Actor actor){
        actorService.addActor(actor);

    }
    @PostMapping("/addactors")
    public void addActors(@RequestBody List<Actor> actors){
        actorService.addActors(actors);

    }

@GetMapping("/getactor/{id}")
    public Actor getActor(@PathVariable int id){
        return actorService.getActor(id);

    }
    @CrossOrigin
    @GetMapping("/getactors")
    public List<Actor> getActors(){
        return actorService.getActors();

    }


    @DeleteMapping("/deleteactor/{id}")
    public void deleteActor(@PathVariable int id){
        actorService.deleteActor(id);

    }
}
