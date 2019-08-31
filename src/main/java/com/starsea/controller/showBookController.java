package com.starsea.controller;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.service.BookDao;
import com.starsea.service.BookEvaluationDao;
import com.starsea.vo.StarEvaluation;
import com.starsea.vo.VueAddBE;
import org.bson.types.ObjectId;
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
        return book;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showBookIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> showBookIndex(Integer num) {
        return bookDao.getBookForIndex(num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showBookByEvaluationNum", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> showBookByEvaluationNum(Integer num) {
        return bookDao.getBookByLikeNum(num);
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
        List<BookEvaluation> bookEvaluations = bookEvaluationDao.getBookEvaluationByIsbn(book.getIsbn(), 2);
        if(bookEvaluations.size() == 0) {
            //String username, ObjectId movieId, double score, String evaluation
            return new BookEvaluation("1", book.getIsbn(), 0, "暂无");
        } else {
            return bookEvaluations.get(0);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/api/addBookEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addBookEvaluation(@RequestBody VueAddBE vueAddBE) {
        String username = vueAddBE.getUsername();
        double score = Double.parseDouble(vueAddBE.getScore());
        String isbn = vueAddBE.getIsbn();
        String evaluation = vueAddBE.getEvaluation();
        if(vueAddBE.getEvaluation().length() < 25) {
            return "请输入25个字符或以上的内容！";
        }
        BookEvaluation bookEvaluation = new BookEvaluation(username, isbn, score, evaluation);
        bookEvaluationDao.addBookEvaluation(bookEvaluation);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/isBookEvaluation", method = RequestMethod.GET)
    @ResponseBody
    public boolean isBookEvaluation(String username, String isbn) {
        if(bookEvaluationDao.getBookEvaluationByUsernameAndIsbn(username, isbn) != null) {
            return true;
        }
        return false;
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
    public String starBookEvaluation(@RequestBody StarEvaluation starEvaluation) {
        String flag = starEvaluation.getFlag();
        String username = starEvaluation.getUsername();
        ObjectId beId = new ObjectId(starEvaluation.getBeId());
        int flags = Integer.parseInt(flag);
        bookEvaluationDao.updateLikeNum(bookEvaluationDao.getBookEvaluationByBeId(beId), username, flags);
        return "SUCCESS";
    }
}