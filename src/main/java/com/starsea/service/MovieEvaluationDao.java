package com.starsea.service;

import com.starsea.entity.MovieEvaluation;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieEvaluationDao {
    public void addMovieEvaluation(MovieEvaluation movieEvaluation);

    public void deleteMovieEvaluation(MovieEvaluation movieEvaluation);

    public List<MovieEvaluation> getMovieEvaluationByUsername(String username);

    public List<MovieEvaluation> getMovieEvaluationByMovieId(ObjectId movieId);
}
