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
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String > addMovieDirectorPair(@RequestParam("q1") String directorName, @RequestParam("q2") String movieName) {
        String response = movieService.addMovieDirectorPair(directorName, movieName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable ("name") String name){
        Movie movie = movieService.getMovieByName(name);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director > getDirectorByName(@PathVariable ("name") String name){
        Director director = movieService.getDirectorByName(name);
            return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable ("name") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam ("name") String directorName) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(directorName), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.CREATED);
    }
}
