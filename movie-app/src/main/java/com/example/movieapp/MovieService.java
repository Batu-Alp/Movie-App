package com.example.movieapp;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
