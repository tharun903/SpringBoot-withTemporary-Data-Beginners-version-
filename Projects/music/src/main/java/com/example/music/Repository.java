package com.example.music;

import java.util.ArrayList;

public interface Repository {
    ArrayList<Model> getSongs();

    Model addSongs(Model songs);

    Model getsongbyId(int songId);

    Model updateSong(Integer songId, Model songs);

    void deleteSong(Integer songId);
}
