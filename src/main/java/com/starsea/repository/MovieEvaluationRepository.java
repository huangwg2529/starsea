package com.starsea.repository;

import com.starsea.entity.MovieEvaluation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieEvaluationRepository extends MongoRepository<MovieEvaluation, ObjectId> {
    public List<MovieEvaluation> findByUsername(String name);

    public List<MovieEvaluation> findByMovieId(ObjectId movieId);

}
