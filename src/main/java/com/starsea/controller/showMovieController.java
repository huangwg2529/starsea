package com.starsea.controller;

import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.service.MovieDao;
import com.starsea.service.MovieEvaluationDao;
import com.starsea.vo.StarEvaluation;
import com.starsea.vo.StarMovieEvaluation;
import com.starsea.vo.VueMovieEvaluation;
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
    @RequestMapping(value = "/api/showOneMovieEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public MovieEvaluation showOneMovieEvaluation(String name) {
        Movie movie = movieDao.getMovieByName(name, "true");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId(), 2).get(0);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showOneTVEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public MovieEvaluation showOneTVEvaluation(String name) {
        Movie movie = movieDao.getMovieByName(name, "false");
        return movieEvaluationDao.getMovieEvaluationByMovieId(movie.getMovieId(), 2).get(0);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/addMovieEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addBookEvaluation(@RequestBody VueMovieEvaluation vueMovieEvaluation) {
        String username = vueMovieEvaluation.getUsername();
        String evaluation = vueMovieEvaluation.getEvaluation();
        double score = Double.parseDouble(vueMovieEvaluation.getScore());
        ObjectId movieId = new ObjectId(vueMovieEvaluation.getId());
        if(evaluation.length() < 25) {
            return "评论失败，请输入25个字符或以上的内容！";
        }
        MovieEvaluation movieEvaluation = new MovieEvaluation(username, movieId, score, evaluation);
        movieEvaluationDao.addMovieEvaluation(movieEvaluation);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/MovieEvaluationIsStar", method = RequestMethod.GET)
    @ResponseBody
    public int movieEvaluationIsStar(ObjectId meId, String username) {
        return movieEvaluationDao.movieEvaluationIsStar(movieEvaluationDao.getMovieEvaluationByMeId(meId), username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/starMovieEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String starBookEvaluation(@RequestBody StarMovieEvaluation starMovieEvaluation) {
        String flag = starMovieEvaluation.getFlag();
        String username = starMovieEvaluation.getUsername();
        ObjectId meId = new ObjectId(starMovieEvaluation.getMeId());
        int flags = Integer.parseInt(flag);
        movieEvaluationDao.updateLikeNum(movieEvaluationDao.getMovieEvaluationByMeId(meId), flags);
        return "SUCCESS";
    }

}
