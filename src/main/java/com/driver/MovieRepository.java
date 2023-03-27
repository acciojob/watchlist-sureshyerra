package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieHashMap = new HashMap<>();
    HashMap<String,Director>directorHashMap = new HashMap<>();
    HashMap<String,List<String>> pairDb = new HashMap<>();


    public String addmovie(Movie movie){

        String name = movie.getName();
        movieHashMap.put(name,movie);
        return "movie added successfully";
    }
    public String addDirector(Director director){

        String name = director.getName();
        directorHashMap.put(name,director);
        return "director added successfully";
    }
    public String addMovieDirectorPair(String movieName,String directorName){


        if(pairDb.containsKey(directorName)){
            List<String> movielist = pairDb.get(directorName);
            movielist.add(movieName);
            return  "pair updated successfully";
        }
        List<String> movielist = new ArrayList<>();
        movielist.add(movieName);
        pairDb.put(directorName,movielist);
        return  "pair updated successfully";
    }
    public Movie  getMovieByName(String name){
        Movie movie = movieHashMap.get(name);
        return movie;
    }

    public Director getDirectorByName(String name){
        Director director = directorHashMap.get(name);
        return director;
    }
    public String deleteDirectorByName(String directorName){
              //director hashmap
        //delete the entries in pairdb
        //corresponding movies

        directorHashMap.remove(directorName);

        List<String > directorlist = pairDb.get(directorName);
        for (String s : directorlist){
            movieHashMap.remove(s);
        }
        pairDb.remove(directorName);
        return "director removed successfully";


    }
    public  String removeEverything(){
        for(List<String> s : pairDb.values()){
            for(String moviename : s){
                movieHashMap.remove(moviename);
            }
        }
        directorHashMap.clear();
        pairDb.clear();
        return "sucessfully removed";
    }
    public List<String> getmovies(String directorName){
        if(pairDb.containsKey(directorName)) {
            return pairDb.get(directorName);
        }
        return null;
    }






    public List<Movie> allmovies(){
        List<Movie> movies = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movies.add(movie);
        }
        return movies;
    }




}
