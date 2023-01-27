package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String, Movie> movieMap = new HashMap<>();
    Map<String, Director> directorMap = new HashMap<>();
    Map<String, List<String>> pairMap = new HashMap<>();

    public String addMovie(Movie movie){
        String ans = movie.getName();
        movieMap.put(ans,movie);
        return "Movie is successfully added";
    }

    public String addDirector(Director director){
        String ans = director.getName();
        directorMap.put(ans,director);
        return "Director is successfully added";
    }

    public String addMovieDirectorPair(String directorName, String movieName){
        if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)) {
            List<String> list = new ArrayList<>();
            if(pairMap.containsKey(directorName)){
                if(pairMap.get(directorName).contains(movieName)){
                    return "Pair already exist";
                }
                list = pairMap.get(directorName);
                list.add(movieName);
                pairMap.put(directorName,list);
            }
            else{
                list.add(movieName);
                pairMap.put(directorName,list);
            }
            return "Pair added Successfully";
        }
        return "Not Found";
    }

    public Movie getMovieByName(String name){

        return movieMap.get(name);
    }

    public Director getDirectorByName(String name){

        return directorMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        if(pairMap.containsKey(name)) {
            return pairMap.get(name);
        }
        return null;
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();
        for(String s : movieMap.keySet()){
            list.add(s);
        }
        return list;
    }

    public String deleteDirectorByName(String directorName) {
        if(directorMap.containsKey(directorName)){
            if(pairMap.containsKey(directorName)){
                List<String> list = pairMap.get(directorName);
                for(String s : list){
                    list.remove(s);
                }
                pairMap.remove(directorName);
            }
            directorMap.remove(directorName);
            return "Delete is Successful";
        }
        return null;
    }

    public String deleteAllDirectors() {
        for(String s :pairMap.keySet()) {
            List<String>list = new ArrayList<>();
            list = pairMap.get(s);
            for(String movie: list) {
                if(movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }
            pairMap.remove(s);
        }
        for(String s:directorMap.keySet()) {
            directorMap.remove(s);
        }
        return "All directors are removed successfully";
    }
}
