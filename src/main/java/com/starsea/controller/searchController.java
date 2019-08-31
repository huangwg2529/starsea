package com.starsea.controller;

import com.starsea.controller.sort.ListSortByScore;
import com.starsea.entity.Book;
import com.starsea.entity.Group;
import com.starsea.entity.Movie;
import com.starsea.entity.Post;
import com.starsea.service.BookDao;
import com.starsea.service.GroupDao;
import com.starsea.service.MovieDao;
import com.starsea.service.PostDao;
import com.starsea.vo.AllList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class searchController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private PostDao postDao;

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

    @CrossOrigin
    @RequestMapping(value = "/api/searchGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> searchGroupByKeyword(String keyword) {
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        return groupDao.getGroupByKeyword(keyword);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchPost", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> searchPostByKeyword(String keyword) {
        if(keyword==null) {
            System.out.println("keyword==null");
            return null;
        }
        return postDao.getPostByKeyword(keyword);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/searchAll", method = RequestMethod.GET)
    @ResponseBody
    public List<AllList> searchAllByKeyword(String keyword) {
        List<Movie> tvs = movieDao.getMovieByKeyword(keyword, "true");
        List<Movie> movies = movieDao.getMovieByKeyword(keyword, "false");
        List<Book> books = bookDao.getBookByKeyword(keyword);
        List<Group> groups = groupDao.getGroupByKeyword(keyword);
        List<Post> posts = postDao.getPostByKeyword(keyword);
        List<AllList> allLists = AllList.transMovieToAllList(tvs);
        allLists.addAll(AllList.transBookToAllList(books));
        allLists.addAll(AllList.transMovieToAllList(movies));
        allLists.addAll(AllList.transGroupToAllList(groups));
        allLists.addAll(AllList.transPostToAllList(posts));
        //按评分排序
        Collections.sort(allLists, new ListSortByScore());
        return allLists;
    }

}
