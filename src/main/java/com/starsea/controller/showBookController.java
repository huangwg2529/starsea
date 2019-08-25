package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class showBookController {

    @Autowired
    private BookDao bookDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showBook", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Book showBook() {
        Book book = bookDao.getBookByName("往事与随想");
        System.out.println(book.getIntroduction());
        return book;
    }
}
