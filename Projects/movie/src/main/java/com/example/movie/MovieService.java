package com.example.movie;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class MovieService implements MovieRepository{

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    int unique = 6;
    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> movieId =  movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(movieId);
        return movies;

    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setMovieId(unique);
        movieList.put(unique,movie);
        unique+=1;
        return movie;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movies = movieList.get(movieId);
        if(movies == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movies;
    }

    @Override
    public Movie updateMovies(Movie movie, int movieId) {
        Movie existingMovie = movieList.get(movieId);
        if(existingMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(movie.getMovieName() != null){
            existingMovie.setMovieName(movie.getMovieName());
        }
        if(movie.getLeadActor() != null){
            existingMovie.setLeadActor(movie.getLeadActor());
        }
        return existingMovie;

    }

    @Override
    public void deleteMovie(int movieId) {
        Movie existingMovie = movieList.get(movieId);
        if(existingMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        movieList.remove(movieId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
