package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.service.BookDao;
import com.starsea.service.BookEvaluationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class showBookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookEvaluationDao bookEvaluationDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showBook", method = RequestMethod.GET)
    @ResponseBody
    public Book showBook(String name) {
        Book book = bookDao.getBookByName(name);
        System.out.println(book.getIntroduction());
        return book;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showBookIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> showBookIndex(Integer num) {
        return bookDao.getBookForIndex(num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showBookEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public List<BookEvaluation> showBookEvaluation(String name, int flag) {
        Book book = bookDao.getBookByName(name);
        return bookEvaluationDao.getBookEvaluationByIsbn(book.getIsbn(), flag);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showOneBookEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public BookEvaluation showOneBookEvaluation(String name) {
        Book book = bookDao.getBookByName(name);
        return bookEvaluationDao.getBookEvaluationByIsbn(book.getIsbn(), 2).get(0);
    }

}
