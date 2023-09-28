package com.example.movieapp.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movieapp.Entity.Movie;
import com.example.movieapp.Entity.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

    // Optional<Review> getReviewByImdbId(String imdbId);

}
