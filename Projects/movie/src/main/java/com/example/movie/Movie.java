package com.example.movie;

public class Movie {
    private Integer movieId;
    private String movieName;
    private String leadActor;

    public Movie(Integer movieId,String movieName,String leadActor) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }
}
