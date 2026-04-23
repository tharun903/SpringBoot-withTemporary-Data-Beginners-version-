package com.example.movie;

import java.util.ArrayList;

public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie addMovie(Movie movie);

    Movie getMovieById(int movieId);

    Movie updateMovies(Movie movie, int movieId);

    void deleteMovie(int movieId);
}
