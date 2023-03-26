package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieservice;
    @PostMapping("/add-movie")

    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = movieservice.addmovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans = movieservice.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("directorname")String directorName){
        String ans = movieservice.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>  getMovieByName(@PathVariable("name")String name){
        Movie movie = movieservice.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirectorByName(@PathVariable("name")String name){
        Director director = movieservice.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam("/directorname")String directorname){
        String ans = movieservice.deleteDirectorByName(directorname);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);

    }
    @DeleteMapping("/delete-all-directors")

    public ResponseEntity<String >deleteAllDirectors(){
        String ans = movieservice.removeeverything();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>>  getMoviesByDirectorName(@PathVariable("directorName") String directorname){
        return new ResponseEntity<>(movieservice.moviesList(directorname),HttpStatus.CREATED);

    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieservice.allmoviesList(),HttpStatus.CREATED);
    }



}
