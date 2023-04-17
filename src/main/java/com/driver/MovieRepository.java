package com.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
     HashMap<String, List<String>> movieDirectorHashMap = new HashMap<>();
     HashMap<String,Director> directorHashMap = new HashMap<>();
     HashMap<String,Movie> movieHashMap = new HashMap<>();
    public String addMovie(Movie movie){


        movieHashMap.put(movie.getName(),movie);

        return "Movie Added";
    }
    public String  addDirector(Director director){

        directorHashMap.put(director.getName(),director);

        return "Director Added";
    }
    public String   addMovieDirectorPair(String movieName,String directorName){
        if(!movieDirectorHashMap.containsKey(directorName)){
            movieDirectorHashMap.put(directorName,new ArrayList<>());
        }
        movieDirectorHashMap.get(directorName).add(movieName);

        return "movie pair added";



    }
    public String deleteDirectorByName(String directorName){

        for (String movie:movieDirectorHashMap.get(directorName)){
            movieHashMap.remove(movie);
        }
        directorHashMap.remove(directorName);
        movieDirectorHashMap.remove(directorName);
        return "deleted";
    }
    public String deleteAllDirectors(){
        for (List<String> s : movieDirectorHashMap.values()){
            for (String movie : s){
                movieHashMap.remove(movie);
            }
        }
        directorHashMap.clear();
        movieDirectorHashMap.clear();
        return "Deleted";
    }
    public List<String> getMoviesByDirectorName(String directorName){
        return movieDirectorHashMap.get(directorName);

    }
    public List<String> findAllMovies(){
        List<String> movies = new ArrayList<>();
        for(String movie : movieHashMap.keySet()){
            movies.add(movie);
        }
        return movies;
    }

    public Movie getMovieByName(String name){
       for (String s : movieHashMap.keySet()){
           if(s.equals(name)){
               return movieHashMap.get(s);
           }
       }
       return null;
    }

    public Director getDirectorByName(String name){
        for(String s : directorHashMap.keySet()){
            if(s.equals(name)){
                return directorHashMap.get(s);
            }
        }
        return null;
    }

}
