package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.entity.Group;
import com.starsea.entity.Movie;
import com.starsea.entity.Post;
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
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        List<Book> books = bookDao.getBookByKeyword(keyword);
        return books;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchMovie", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> searchMovieByKeyword(String keyword) {
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        List<Movie> movies = movieDao.getMovieByKeyword(keyword, "true");
        return movies;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchTV", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> searchTVByKeyword(String keyword) {
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        List<Movie> movies = movieDao.getMovieByKeyword(keyword, "false");
        return movies;
    }

    /*
    @CrossOrigin
    @RequestMapping(value = "/api/searchAll", method = RequestMethod.GET)
    @ResponseBody
    public AllList searchAllByKeyword(String keyword) {
        AllList allList = new AllList();
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        List<Movie> tvs = movieDao.getMovieByKeyword(keyword, "true");
        List<Movie> movies = movieDao.getMovieByKeyword(keyword, "false");
        List<Book> books =
        return movies;
    }
     */

}


class AllList {
    List<Book> books;
    List<Movie> movies;
    List<Movie> TVs;
    List<Group> groups;
    List<Post> posts;

    public AllList() {

    }

    public AllList(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public AllList(List<Book> books, List<Movie> movies, List<Movie> TVs, List<Group> groups, List<Post> posts) {
        this.books = books;
        this.movies = movies;
        this.TVs = TVs;
        this.groups = groups;
        this.posts = posts;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getTVs() {
        return TVs;
    }

    public void setTVs(List<Movie> TVs) {
        this.TVs = TVs;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}