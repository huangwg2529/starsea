package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class showBookController {
    @Autowired
    private BookDao bookDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showBook", method = RequestMethod.GET)
    @ResponseBody
    public Book showBook() {
        Book book = bookDao.getBookByName("我想吃掉你的胰脏");
        System.out.println(book.getIntroduction());
        return book;
    }

}
