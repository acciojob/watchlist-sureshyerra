package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepository;

    public String addmovie(Movie movie){
        return movierepository.addmovie(movie);
    }
    public String addDirector(Director director){
        return movierepository.addDirector(director);
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        return movierepository.addMovieDirectorPair(movieName,directorName);
    }
    public Movie  getMovieByName(String name){
        return movierepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movierepository.getDirectorByName(name);
    }
    public String deleteDirectorByName(String directorName){
        return movierepository.deleteDirectorByName(directorName);

    }
    public String removeeverything(){
        return movierepository.removeEverything();
    }
    public List<String> getMoviesByDirectorName(String name){
        return movierepository.getmovies(name);
    }
    public List<Movie> allmoviesList(){
        return movierepository.allmovies();
    }


}
