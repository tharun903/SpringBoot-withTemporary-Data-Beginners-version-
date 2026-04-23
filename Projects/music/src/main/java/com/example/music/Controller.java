package com.example.music;

import org.springframework.web.bind.annotation.*;
import com.example.music.Service;
import java.util.ArrayList;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping("/songs")
    public ArrayList<Model> getsongs(){
        return service.getSongs();
    }

    @PostMapping("/songs")
    public Model addsongs(@RequestBody Model songs){
        return service.addSongs(songs);
    }

    @GetMapping("/songs/{songId}")
    public Model getsongbyId(@PathVariable("songId") Integer songId){
        return service.getsongbyId(songId);
    }

    @PutMapping("/songs/{songId}")
    public Model updateSong(@PathVariable("songId") Integer songId,@RequestBody Model songs){
        return service.updateSong(songId,songs);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") Integer songId){
        service.deleteSong(songId);
    }
}
