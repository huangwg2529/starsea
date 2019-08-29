package com.starsea.service;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.enums.Region;
import com.starsea.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
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
        List<MovieEvaluation> evaluations = movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId(), 1);
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
        mongoTemplate.updateFirst(query, update, Movie.class);
    }

    public List<Movie> getMovieForIndex(int num, String flag) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "score");
        Criteria criteria = Criteria.where("flag").is(flag);
        Query query = new Query(criteria);
        //感谢：https://blog.csdn.net/john_1023/article/details/90522618
        query.with(Sort.by(order)).limit(num);
        return mongoTemplate.find(query, Movie.class);
    }

    public Movie getMovieByName(String name, String flag) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is(name), Criteria.where("flag").is(flag));
        Movie movie = mongoTemplate.findOne(new Query(criteria), Movie.class);
        System.out.println(movie.getIntroduction());
        return movie;
    }

    public Movie getMovieByDirector(String director, String flag) {
        Query query = new Query();
        query.addCriteria(Criteria.where("director").is(director));
        query.addCriteria(Criteria.where("flag").is(flag));
        return mongoTemplate.findOne(query, Movie.class);
    }

    public List<Movie> getMovieByStars(String stars, String flag) {
        Query query = new Query();
        query.addCriteria(Criteria.where("stars").regex(stars));
        query.addCriteria(Criteria.where("flag").is(flag));
        return mongoTemplate.find(query, Movie.class);
    }

    public Movie getMovieByRegion(String region, String flag) {
        Query query = new Query();
        query.addCriteria(Criteria.where("region").is(region));
        query.addCriteria(Criteria.where("flag").is(flag));
        return mongoTemplate.findOne(query, Movie.class);
    }

    public Movie getMovieByReleaseYear(int releaseYear, String flag) {
        Query query = new Query();
        query.addCriteria(Criteria.where("releaseYear").is(releaseYear));
        query.addCriteria(Criteria.where("flag").is(flag));
        return mongoTemplate.findOne(query, Movie.class);
    }

    public List<Movie> getMovieByKeyword(String keyword, String flag) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(keyword));
        query.addCriteria(Criteria.where("flag").is(flag));
        return mongoTemplate.find(query, Movie.class);
    }

}
