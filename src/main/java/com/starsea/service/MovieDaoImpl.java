package com.starsea.service;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.enums.Region;
import com.starsea.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDaoImpl implements MovieDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieEvaluationDao movieEvaluationDao;

    public void addMovie(Movie movie) {
        movieRepository.insert(movie);
    }

    public void deleteMoive(Movie movie) {
        movieRepository.delete(movie);
    }

    public void updateMovieScore(Movie movie) {
        List<MovieEvaluation> evaluations = movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId());
        int count = evaluations.size();
        double scoreTotal = 0;
        for(int i=0; i<count; i++) {
            scoreTotal += evaluations.get(i).getScore();
        }
        //保留一位小数
        double scoreAvg = (double) Math.round(scoreTotal/count*10)/10;
        Query query = Query.query(Criteria.where("movieId").is(movie.getMovieId()));
        Update update = new Update();
        update.set("score", scoreAvg);
        update.set("evaluationNum", count);
        mongoTemplate.updateFirst(query, update, "movies");
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public Movie getMovieByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    public List<Movie> getMovieByStars(String stars) {
        return movieRepository.findByStars(stars);
    }

    public Movie getMovieByRegion(Region region) {
        return movieRepository.findByRegion(region);
    }

    public Movie getMovieByReleaseYear(int releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }

    public List<Movie> getMovieByKeyword(String keyword) {
        return movieRepository.findByNameLike(keyword);
    }

}
