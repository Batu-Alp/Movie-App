package com.example.movieapp.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieapp.Entity.Movie;
import com.example.movieapp.Service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.movieById(imdbId), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Optional<Movie>> getMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<Optional<Movie>>(movieService.movieByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/genres/{genres}")
    public ResponseEntity<List<Movie>> getMoviesByGenres(@PathVariable String genres) {
        return new ResponseEntity<List<Movie>>(movieService.moviesByGenres(genres), HttpStatus.OK);
    }

    @GetMapping("/sortByASC")
    public ResponseEntity<List<Movie>> getMoviesSortedByReleaseDateOldestToNewest() {
        return new ResponseEntity<List<Movie>>(movieService.moviesSortedByReleaseDateOldestToNewest(),
                HttpStatus.OK);
    }

    @GetMapping("/sortByDESC")
    public ResponseEntity<List<Movie>> getMoviesSortedByReleaseDateNewestToOldest() {
        return new ResponseEntity<List<Movie>>(movieService.moviesSortedByReleaseDateNewestToOldest(),
                HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestParam String imdbId, @RequestParam String title,
            @RequestParam String releaseDate,
            @RequestParam List<String> genres) {

        return new ResponseEntity<Movie>(
                movieService.createMovie(imdbId, title, releaseDate, genres),
                HttpStatus.OK);

    }

    /*
     * @GetMapping("/all")
     * public ResponseEntity<String> getAllMovies() {
     * return new ResponseEntity<String>("All movies!", HttpStatus.OK);
     * }
     */

}
