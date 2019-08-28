package com.starsea.controller;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.service.MovieDao;
import com.starsea.service.MovieEvaluationDao;
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
    public List<MovieEvaluation> showMovieEvaluation(String name) {
        Movie movie = movieDao.getMovieByName(name, "true");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId());
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showTVEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public List<MovieEvaluation> showTVEvaluation(String name) {
        Movie movie = movieDao.getMovieByName(name, "false");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId());
    }
}
