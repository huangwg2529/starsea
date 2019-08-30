package com.starsea.controller;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.service.MovieDao;
import com.starsea.service.MovieEvaluationDao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class showMovieController {
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieEvaluationDao movieEvaluationDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showMovieIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> showMovieIndex(Integer num) {
        return movieDao.getMovieForIndex(num, "true");
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showTVIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> showTVIndex(Integer num) {
        return movieDao.getMovieForIndex(num, "false");
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showMovie", method = RequestMethod.GET)
    @ResponseBody
    public Movie showMovie(String name) {
        Movie movie = movieDao.getMovieByName(name, "true");
        return movie;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showTV", method = RequestMethod.GET)
    @ResponseBody
    public Movie showTV(String name) {
        Movie movie = movieDao.getMovieByName(name, "false");
        return movie;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showMovieEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public List<MovieEvaluation> showMovieEvaluation(String name, int flag) {
        Movie movie = movieDao.getMovieByName(name, "true");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId(), flag);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showTVEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public List<MovieEvaluation> showTVEvaluation(String name, int flag) {
        Movie movie = movieDao.getMovieByName(name, "false");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId(), flag);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/addMovieEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addBookEvaluation(@RequestBody String username, @RequestBody ObjectId movieId, @RequestBody String score, @RequestBody String evaluation) {
        if(evaluation.length() < 25) {
            return "评论失败，请输入25个字符或以上的内容！";
        }
        double scoreD = Double.parseDouble(score);
        MovieEvaluation movieEvaluation = new MovieEvaluation(username, movieId, scoreD, evaluation);
        movieEvaluationDao.addMovieEvaluation(movieEvaluation);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/MovieEvaluationIsStar", method = RequestMethod.GET)
    @ResponseBody
    public int movieEvaluationIsStar(ObjectId meId, String username) {
        return movieEvaluationDao.movieEvaluationIsStar(movieEvaluationDao.getMovieEvaluationByMeId(meId), username);
    }

}
