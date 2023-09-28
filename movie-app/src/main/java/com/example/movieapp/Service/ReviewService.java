package com.example.movieapp.Service;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.movieapp.Entity.Movie;
import com.example.movieapp.Entity.Review;
import com.example.movieapp.Repository.MovieRepository;
import com.example.movieapp.Repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        // Review review = new Review(reviewBody);

        Review review = reviewRepository.save(new Review(reviewBody));

        // Optional<Review> optionalReview = reviewRepository.getReviewByImdbId(imdbId);
        // Updating reviewIds arrays
        // imbdId ye göre match ediliyor
        // Review reviews = optionalReview.get();

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        /*
         * Optional<Movie> optionalMovie = movieRepository.getMovieByImdbId(imdbId);
         * Movie movie = optionalMovie.get();
         * Review review = new Review(reviewBody);
         * 
         * if (movie != null) {
         * mongoTemplate.update(Movie.class)
         * .matching(Criteria.where("imdbId").is(imdbId))
         * .apply(new Update().push("reviewIds").value(review))
         * .first();
         * }
         */

        return review;

    }

}
