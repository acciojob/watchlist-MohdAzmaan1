package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        String response = movieRepository.addMovie(movie);
        return response;
    }

    public String addDirector(Director director){
        String response = movieRepository.addDirector(director);
        return response;
    }

    public String addMovieDirectorPair(String directorname, String moviename){
        String response = movieRepository.addMovieDirectorPair(directorname, moviename);
        return response;
    }

    public Movie getMovieByName(String name){
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }

    public Director getDirectorByName(String name){
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String directorname) {
        return movieRepository.deleteDirectorByName(directorname);
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }
}
