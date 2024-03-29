package com.example.movieapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.movieapp.Entity.Movie;
import com.example.movieapp.Entity.Review;
import com.example.movieapp.Repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imbdId) {

        Review review = reviewRepository.insert(new Review(reviewBody));

        // Updating reviewIds arrays
        // imbdId ye göre match ediliyor
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imbdId").is(imbdId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }

}
