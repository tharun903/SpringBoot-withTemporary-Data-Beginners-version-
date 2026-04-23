package com.example.music;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@org.springframework.stereotype.Service
public class Service implements Repository{
    private static HashMap<Integer, Model> playlist = new HashMap<>();
    int uniqueId = 6;

    public Service() {
        playlist.put(1, new Model(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Model(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Model(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Model(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Model(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override
    public ArrayList<Model> getSongs() {
        Collection<Model> songId = playlist.values();
        ArrayList<Model> songs = new ArrayList<>(songId);
        return songs;


    }

    @Override
    public Model addSongs(Model songs) {
        songs.setSongId(uniqueId);
        playlist.put(uniqueId,songs);
        uniqueId+=1;
        return songs;

    }

    @Override
    public Model getsongbyId(int songId) {
        Model song = playlist.get(songId);
        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Model updateSong(Integer songId, Model songs) {
        Model existingsong = playlist.get(songId);
        if(existingsong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(songs.getSongName() != null){
            existingsong.setSongName(songs.getSongName());
        }
        if(songs.getLyricist() != null){
            existingsong.setLyricist(songs.getLyricist());
        }
        if(songs.getSinger() != null){
            existingsong.setSinger((songs.getSinger()));
        }
        if(songs.getMusicDirector() != null){
            existingsong.setMusicDirector((songs.getMusicDirector()));
        }
        return existingsong;
    }

    @Override
    public void deleteSong(Integer songId) {
        Model song = playlist.get(songId);
        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(song != null){
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
