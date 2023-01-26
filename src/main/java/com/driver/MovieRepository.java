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
        return "Movie is sucessfully added";
    }

    public String addDirector(Director director){
        String ans = director.getName();
        directorMap.put(ans,director);
        return "Director is sucessfully added";
    }

    public String addMovieDirectorPair(String directorname, String moviename){
        if(movieMap.containsKey(moviename) && directorMap.containsKey(directorname)) {
            if(pairMap.containsKey(directorname)) {
                pairMap.get(directorname).add(moviename);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(moviename);
                pairMap.put(directorname,list);
            }
        }
        return "Director-Movie pair is sucessfully added";
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

    public String deleteDirectorByName(String directorname) {
        if(directorMap.containsKey(directorname)){
            if(pairMap.containsKey(directorname)){
                List<String> list = pairMap.get(directorname);
                for(String s : list){
                    list.remove(s);
                }
                pairMap.remove(directorname);
            }
            directorMap.remove(directorname);
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
