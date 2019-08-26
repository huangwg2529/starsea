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
    //@RequestMapping(value = "/api/index", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    //@ResponseBody
    @RequestMapping(value = "/api/index", method = RequestMethod.GET)
    @ResponseBody
    public String showBook(@RequestParam("name") String name){
        System.out.println(name);
        return name + " get and post!";
    }


    /*
    public Book showBook(@RequestBody String name) {
        System.out.println("index get  " + name);
        Book book = bookDao.getBookByName(name);
        System.out.println(book.getIntroduction());
        return book;
    }

     */


    /**
    @CrossOrigin
    @RequestMapping(value = "/api/index", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Book showBook(@RequestBody String name) {
        Book book = bookDao.getBookByName(name);
        System.out.println(book.getIntroduction());
        return book;
    }
    */
}
