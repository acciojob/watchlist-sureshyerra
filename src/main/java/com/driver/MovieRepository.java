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
    HashMap<String,String> pairDb = new HashMap<>();

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

        pairDb.put(movieName,directorName);
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

        //iterate
        for(Map.Entry<String,String> entry : pairDb.entrySet()){
            if (entry.getValue().equals(directorName)){
                String moviename = entry.getKey();
                movieHashMap.remove(moviename);
                pairDb.remove(moviename);
            }

        }
        return "director removed successfully";


    }
    public  String removeEverything(){
        for(String directorname : directorHashMap.keySet()){
            directorHashMap.remove(directorname);
            for(Map.Entry<String,String> entry : pairDb.entrySet()){
               if(entry.getValue().equals(directorname)){
                   String moviename = entry.getKey();
                   movieHashMap.remove(moviename);
                   pairDb.remove(moviename);
               }

            }
        }
        return "sucessfully removed";
    }
    public List<Movie> moviesList(String directorname){
        List<Movie> movies = new ArrayList<>();

        for (Map.Entry<String,String> entry : pairDb.entrySet()){
            if(entry.getValue().equals(directorname)){
                String moviename = entry.getKey();
                Movie movie = movieHashMap.get(moviename);
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<Movie> allmovies(){
        List<Movie> movies = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movies.add(movie);
        }
        return movies;
    }




}
