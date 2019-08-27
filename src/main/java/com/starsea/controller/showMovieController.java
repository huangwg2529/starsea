package com.starsea.controller;

import com.starsea.entity.Movie;
import com.starsea.service.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class showMovieController {
    @Autowired
    private MovieDao movieDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showMovie", method = RequestMethod.GET)
    @ResponseBody
    public Movie showMovie(String name) {
        Movie movie = movieDao.getMovieByName(name);
        System.out.println(movie.getIntroduction());
        return movie;
    }
}
