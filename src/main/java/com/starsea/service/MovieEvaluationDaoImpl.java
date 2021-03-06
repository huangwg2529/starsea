package com.starsea.service;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.repository.MovieEvaluationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieEvaluationDaoImpl implements MovieEvaluationDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MovieEvaluationRepository movieEvaluationRepository;
    @Autowired
    private UserDao userDao;

    public void addMovieEvaluation(MovieEvaluation movieEvaluation) {
        movieEvaluationRepository.insert(movieEvaluation);
        userDao.updateCollectMovies(movieEvaluation.getUsername(), movieEvaluation.getMovieId());
    }

    public void deleteMovieEvaluation(MovieEvaluation movieEvaluation) {
        movieEvaluationRepository.delete(movieEvaluation);
    }

    public List<MovieEvaluation> getMovieEvaluationByUsername(String username) {
        return mongoTemplate.find(new Query(Criteria.where("username").is(username)), MovieEvaluation.class);
    }

    public MovieEvaluation getMovieEvaluationByMeId(ObjectId meId) {
        return movieEvaluationRepository.findByMeId(meId);
    }

    public List<MovieEvaluation> getMovieEvaluationByMovieId(ObjectId movieId, int flag) {
        Sort.Order order;
        if(flag == 1) {
            order = new Sort.Order(Sort.Direction.DESC, "likeNum");
        } else {
            order = new Sort.Order(Sort.Direction.DESC, "date");
        }
        Query query = new Query(Criteria.where("movieId").is(movieId));
        query.with(Sort.by(order));
        return mongoTemplate.find(query, MovieEvaluation.class);
    }

    public MovieEvaluation getMovieEvaluationByUsernameAndMovieId(String username, ObjectId movieId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("movieId").is(movieId));
        return mongoTemplate.findOne(query, MovieEvaluation.class);
    }

    @Override
    public void updateLikeNum(MovieEvaluation movieEvaluation, int flag) {
        Query query = new Query(Criteria.where("meId").is(movieEvaluation.getMeId()));
        Update update = new Update();
        update.set("likeNum", movieEvaluation.getLikeNum()+flag);
        mongoTemplate.updateFirst(query, update, MovieEvaluation.class);
    }

    @Override
    public int movieEvaluationIsStar(MovieEvaluation movieEvaluation, String username) {
        List<String> starUsernames = movieEvaluation.getStarUsername();
        if(starUsernames.contains(username)) {
            return 1;
        }
        return 0;
    }
}
