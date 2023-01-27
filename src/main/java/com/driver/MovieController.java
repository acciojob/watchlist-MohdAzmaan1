package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity addMovieDirectorPair(@RequestParam("q1") String movieName, @RequestParam("q2") String directorName) {
        String response = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable ("name") String name){
        Movie movie = movieService.getMovieByName(name);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable ("name") String name){
        Director director = movieService.getDirectorByName(name);
            return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable ("name") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam ("name") String directorName) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(directorName), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.CREATED);
    }
}
//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//public class MovieController {
//
//    @Autowired
//    MovieService movieService;
//
//    @PostMapping("/movies/add-movie")
//    public ResponseEntity addMovie(@RequestBody Movie movie)
//    {
//        String response =movieService.addMovie(movie);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//    @PostMapping("/movies/add-director")
//    public ResponseEntity addDirector(@RequestBody Director director)
//    {
//        String response =movieService.addDirector(director);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
//    @PutMapping("/movies/add-movie-director-pair")
//    public ResponseEntity addMovieDirectorPair(@RequestParam("nameM") String nameM,@RequestParam("nameD") String nameD)
//    {
//        String response=movieService.addMovieDirectorPair(nameM,nameD);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
//    @GetMapping("/movies/get-movie-by-name/{nameM}")
//    public ResponseEntity getMovieByName(@PathVariable("nameM") String nameM)
//    {
//        Movie movie = movieService.getMovieByName(nameM);
//        return new ResponseEntity<>(movie,HttpStatus.FOUND);
//    }
//    @GetMapping("/movies/get-director-by-name/{nameD}")
//    public ResponseEntity getDirectorByName(@PathVariable("nameD") String nameD)
//    {
//        Director director = movieService.getDirectorByName(nameD);
//        return new ResponseEntity<>(director,HttpStatus.FOUND);
//    }
//
//    @GetMapping("/movies/get-movies-by-director-name/{nameD}")
//    public ResponseEntity getMoviesByDirectorName(@PathVariable("nameD") String nameD)
//    {
//        List<String>ml=new ArrayList<>();
//
//        ml= movieService.getMoviesByDirectorName(nameD);
//        return new ResponseEntity<>(ml,HttpStatus.FOUND);
//    }
//
//    @GetMapping("/movies/get-all-movies")
//    public ResponseEntity findAllMovies()
//    {
//        List<String>ml=new ArrayList<>();
//        ml=movieService.findAllMovies();
//        return new ResponseEntity(ml,HttpStatus.FOUND);
//    }
//
//    @DeleteMapping("/movies/delete-director-by-name")
//    public ResponseEntity deleteDirectorByName(@RequestParam("nameD") String nameD)
//    {
//        String response=movieService.deleteDirectorByName(nameD);
//        return new ResponseEntity(response,HttpStatus.ACCEPTED);
//
//    }
//    @DeleteMapping("/movies/delete-all-directors")
//    public ResponseEntity deleteAllDirectors()
//    {
//        String response=movieService.deleteAllDirectors();
//        return new ResponseEntity(response,HttpStatus.ACCEPTED);
//    }
//}