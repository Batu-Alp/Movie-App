package com.example.movieapp.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.movieapp.Entity.Movie;
import com.example.movieapp.Repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    public MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    // bu method null da dönebilir
    /*
     * public Optional<Movie> movieById(ObjectId id) {
     * return movieRepository.findById(id);
     * }
     */

    public Optional<Movie> movieById(String imdbId) {
        return movieRepository.getMovieByImdbId(imdbId);
    }

    public Optional<Movie> movieByTitle(String title) {
        return movieRepository.getMovieByTitle(title);
    }

    public List<Movie> moviesByGenres(String genres) {

        List<Movie> movies = movieRepository.getMoviesByGenres(genres);
        return movies;
    }

    public List<Movie> moviesSortedByReleaseDateOldestToNewest() {
        // Tüm filmleri alın
        List<Movie> movies = movieRepository.findAll(Sort.by("releaseDate")); // movieRepository, veritabanınıza erişim
        return movies;
    }

    public List<Movie> moviesSortedByReleaseDateNewestToOldest() {
        // Tüm filmleri alın
        List<Movie> movies = movieRepository.findAll(Sort.by(Sort.Direction.DESC, "releaseDate"));
        return movies;
    }

}
