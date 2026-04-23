package com.example.movie;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
    @GetMapping("/movies")
    public ArrayList<Movie> getMovies(){
        return service.getMovies();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId){
        return service.getMovieById(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovies(@RequestBody Movie movie ,@PathVariable("movieId") int movieId){
        return service.updateMovies(movie,movieId);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId){
        service.deleteMovie(movieId);
    }
}
