package com.example.music;

public class Model {
    private Integer songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Model(Integer SongId,String songName,String lyricist,String singer,String musicDirector){
        this.songId = SongId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicDirector() {
        return musicDirector;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }
}
