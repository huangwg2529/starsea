package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.service.BookDao;
import com.starsea.service.BookEvaluationDao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

    @CrossOrigin
    @RequestMapping(value = "/api/addBookEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addBookEvaluation(@RequestBody String username, @RequestBody String isbn, @RequestBody double score, @RequestBody String evaluation) {
        if(evaluation.length() < 25) {
            return "评论失败，请输入25个字符或以上的内容！";
        }
        BookEvaluation bookEvaluation = new BookEvaluation(username, isbn, score, evaluation);
        bookEvaluationDao.addBookEvaluation(bookEvaluation);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/BookEvaluationIsStar", method = RequestMethod.GET)
    @ResponseBody
    public int bookEvaluationIsStar(ObjectId beId, String username) {
        return bookEvaluationDao.bookEvaluationIsStar(bookEvaluationDao.getBookEvaluationByBeId(beId), username);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/starBookEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String starBookEvaluation(@RequestBody ObjectId beId, @RequestBody String username, int flag) {
        bookEvaluationDao.updateLikeNum(bookEvaluationDao.getBookEvaluationByBeId(beId), username, flag);
        return "SUCCESS";
    }
}
