package com.starsea.service;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookEvaluationDao bookEvaluationDao;

    //增
    @Override
    public void addBook(Book book){
        bookRepository.insert(book);
    }

    //删
    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    //改
    @Override
    public void updateBook(Book book) {
        //userRepository.
        //mongoTemplate.
    }

    //更新评分，每新增一个评论就要更新
    public void updateBookScore(Book book) {
        List<BookEvaluation> evaluations = bookEvaluationDao.getBookEvaluationByIsbn(book.getIsbn());
        int count = evaluations.size();
        double scoreTotal = 0;
        for(int i=0; i<count; i++) {
            scoreTotal += evaluations.get(i).getScore();
        }
        //book.setScore(scoreTotal/count);
        //更新数据库中的评分
        Query query = Query.query(Criteria.where("isbn").is(book.getIsbn()));
        Update update = new Update();
        update.set("score", scoreTotal/count);
        mongoTemplate.updateFirst(query, update, "books");
    }

    //查
    @Override
    public Book getBookByName(String name){
        return bookRepository.findByName(name);
    }

    @Override
    public Book getBookByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book getBookByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    //关键字查询
    @Override
    public List<Book> getBookByKeyword(String keyword){
        Query query = Query.query(Criteria.where("name").regex(keyword));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }


}