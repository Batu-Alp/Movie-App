package com.example.movieapp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movieapp.Entity.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
