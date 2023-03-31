package com.driver;

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
        String key = movie.getName();
        movieHashMap.put(key,movie);

        return "Movie Added";
    }
    public String  addDirector(Director director){
        String key = director.getName();
        directorHashMap.put(key,director);

        return "Director Added";
    }
    public String   addMovieDirectorPair(String movieName,String directorName){
      if(movieDirectorHashMap.containsKey(directorName)){
          List<String> movies = movieDirectorHashMap.get(directorName);
          movies.add(movieName);
          movieDirectorHashMap.put(directorName,movies);
          return "Movie and Director Paired";
      }
      else {
          List<String> movies = new ArrayList<>();
          movies.add(movieName);
          movieDirectorHashMap.put(directorName,movies);
          return "Movie and Director Paired";
      }

    }
    public String deleteDirectorByName(String directorName){
        directorHashMap.remove(directorName);
        if(movieDirectorHashMap.containsKey(directorName)){
            List<String> students = movieDirectorHashMap.get(directorName);
            for(String s : students) {
                movieHashMap.remove(s);
            }
        }
        movieDirectorHashMap.remove(directorName);
        return "deleted";
    }
    public String deleteAllDirectors(){
        for(List<String> s : movieDirectorHashMap.values()){
            for(String students : s){
                movieHashMap.remove(students);
            }
        }
        directorHashMap.clear();
        movieDirectorHashMap.clear();
        return "Deleted";
    }
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> res = new ArrayList<>();
        if(movieDirectorHashMap.containsKey(directorName))
            res =  movieDirectorHashMap.get(directorName);
        return new ArrayList<>();
    }
    public List<String> findAllMovies(){
        List<String> movies = new ArrayList<>();
        for(String movie : movieHashMap.keySet()){
            movies.add(movie);
        }
        return movies;
    }

    public Movie getMovieByName(String name){
        if (movieHashMap.containsKey(name)){
            Movie movie = movieHashMap.get(name);
            return movie;
        }
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorHashMap.containsKey(name))
            return directorHashMap.get(name);
        return null;
    }

}
