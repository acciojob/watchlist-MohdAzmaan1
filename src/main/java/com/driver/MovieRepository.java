//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MovieRepository {
//
//    Map<String, Movie> movieMap = new HashMap<>();
//    Map<String, Director> directorMap = new HashMap<>();
//    Map<String, List<String>> pairMap = new HashMap<>();
//
//    public String addMovie(Movie movie){
//        String ans = movie.getName();
//        movieMap.put(ans,movie);
//        return "Movie is successfully added";
//    }
//
//    public String addDirector(Director director){
//        String ans = director.getName();
//        directorMap.put(ans,director);
//        return "Director is successfully added";
//    }
//
//    public String addMovieDirectorPair(String directorName, String movieName){
//        if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)) {
//            List<String> list = new ArrayList<>();
//            if(pairMap.containsKey(directorName)){
//                if(pairMap.get(directorName).contains(movieName)){
//                    return "Pair already exist";
//                }
//                list = pairMap.get(directorName);
//                list.add(movieName);
//                pairMap.put(directorName,list);
//            }
//            else{
//                list.add(movieName);
//                pairMap.put(directorName,list);
//            }
//            return "Pair added Successfully";
//        }
//        return "Not Found";
//    }
//
//    public Movie getMovieByName(String name){
//
//        return movieMap.get(name);
//    }
//
//    public Director getDirectorByName(String name){
//
//        return directorMap.get(name);
//    }
//
//    public List<String> getMoviesByDirectorName(String name) {
//        if(pairMap.containsKey(name)) {
//            return pairMap.get(name);
//        }
//        return null;
//    }
//
//    public List<String> findAllMovies() {
//        List<String> list = new ArrayList<>();
//        for(String s : movieMap.keySet()){
//            list.add(s);
//        }
//        return list;
//    }
//
//    public String deleteDirectorByName(String directorName) {
//        if(directorMap.containsKey(directorName)){
//            if(pairMap.containsKey(directorName)){
//                List<String> list = pairMap.get(directorName);
//                for(String s : list){
//                    list.remove(s);
//                }
//                pairMap.remove(directorName);
//            }
//            directorMap.remove(directorName);
//            return "Delete is Successful";
//        }
//        return null;
//    }
//
//    public String deleteAllDirectors() {
//        for(String s :pairMap.keySet()) {
//            List<String>list = new ArrayList<>();
//            list = pairMap.get(s);
//            for(String movie: list) {
//                if(movieMap.containsKey(movie)) {
//                    movieMap.remove(movie);
//                }
//            }
//            pairMap.remove(s);
//        }
//        for(String s:directorMap.keySet()) {
//            directorMap.remove(s);
//        }
//        return "All directors are removed successfully";
//    }
//}
package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie>Mdb=new HashMap<>();
    HashMap<String,Director>Ddb=new HashMap<>();
    HashMap<String, List<String>>Pdb=new HashMap<>();

    public String addMovie(Movie movie)
    {
        String name=movie.getName();
        Mdb.put(name,movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director)
    {
        String name=director.getName();
        Ddb.put(name,director);
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String nameM,String nameD)
    {
        if(Mdb.containsKey(nameM)&&Ddb.containsKey(nameD))
        {
            List<String>ml=new ArrayList<>();
            if(Pdb.containsKey(nameD))
            {
                if(Pdb.get(nameD).contains(nameM))
                {
                    return "Pair already exist";
                }
                ml=Pdb.get(nameD);
                ml.add(nameM);
                Pdb.put(nameD,ml);
            }
            else
            {
                ml.add(nameM);
                Pdb.put(nameD,ml);
            }
            return "Pair added successfully";
        }
        return "database does not contains pair";

    }

    public Movie getMovieByName(String nameM)
    {
        if(Mdb.containsKey(nameM))
        {
            return Mdb.get(nameM);
        }
        return null ;
    }
    public Director getDirectorByName(String nameD)
    {
        if(Ddb.containsKey(nameD))
        {
            return Ddb.get(nameD);
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String nameD)
    {
        if(Pdb.containsKey(nameD))
        {
            return Pdb.get(nameD);
        }
        return null;
    }
    public List<String> findAllMovies()
    {
        List<String>allmovie=new ArrayList<>();
        for(String m:Mdb.keySet())
        {
            allmovie.add(m);
        }
        return allmovie;
    }
    public String deleteDirectorByName(String nameD)
    {
        List<String>ml=new ArrayList<>();
        if(Pdb.containsKey(nameD))
        {
            ml=Pdb.get(nameD);
        }
        for(String movie:ml)
        {
            if(Mdb.containsKey(movie))
            {
                Mdb.remove(movie);
            }
        }
        Pdb.remove(nameD);
        if(Ddb.containsKey(nameD))
        {
            Ddb.remove(nameD);
        }
        return "Director and its movies removed successfully";
    }
    public String deleteAllDirectors()
    {
        for(String D:Pdb.keySet())
        {
            List<String>dml=new ArrayList<>();
            dml=Pdb.get(D);
            for(String movie:dml)
            {
                if(Mdb.containsKey(movie))
                {
                    Mdb.remove(movie);
                }
            }
            Pdb.remove(D);
        }
        for(String D:Ddb.keySet())
        {
            Ddb.remove(D);
        }
        return "All directors and all of their movies removed successfully";

    }
}