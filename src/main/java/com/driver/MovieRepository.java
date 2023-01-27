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

    public List<String> getMoviesByDirectorName(String name){
        List<String> list = new ArrayList<>();
        if(pairMap.containsKey(name)) {
            list = pairMap.get(name);
        }
        return list;
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
        ArrayList<String> list=new ArrayList<>();
        for(String s:pairMap.keySet()){
            for(String m:pairMap.get(s)){
                list.add(m);
            }
        }

        for(String i:list){
            movieMap.remove(i);
        }
        return  "All Directors are deleted Successfully";
    }
}
