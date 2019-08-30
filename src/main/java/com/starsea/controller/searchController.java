package com.starsea.controller;

import com.starsea.controller.sort.BookSortByEvaluation;
import com.starsea.controller.sort.MovieSortByEvaluation;
import com.starsea.entity.Book;
import com.starsea.entity.Movie;
import com.starsea.service.BookDao;
import com.starsea.service.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class searchController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private MovieDao movieDao;

    @CrossOrigin
    @RequestMapping(value = "/api/searchBook", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> searchBookByKeyword(String keyword) {
        List<Book> books = bookDao.getBookByKeyword(keyword);
        return books;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchMovie", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> searchMovieByKeyword(String keyword) {
        List<Movie> movies = movieDao.getMovieByKeyword(keyword, "true");
        return movies;
    }



}
