package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String directorname, @RequestParam String moviename){
        String response = movieService.addMovieDirectorPair(directorname, moviename);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable ("name") String name){
        Movie movie = movieService.getMovieByName(name);
        if(movie!=null){
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable ("name") String name){
        Director director = movieService.getDirectorByName(name);
        if(director!=null){
            return new ResponseEntity<>(director, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(director, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable ("name") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam ("name") String directorname) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(directorname), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.CREATED);
    }
}
