package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class showBookController {
    @Autowired
    private BookDao bookDao;

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
}
