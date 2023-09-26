package com.example.movieapp.Repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movieapp.Entity.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> getMovieByImdbId(String imdbId);

    Optional<Movie> getMovieByTitle(String title);

    List<Movie> getMoviesByGenres(String genres);

}
