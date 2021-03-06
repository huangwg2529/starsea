package com.starsea.service;

import com.starsea.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookDao {
    //用户只能查询，不能增删改
    public void addBook(Book book);
    public void deleteBook(Book book);
    public void updateBook(Book book);

    public void updateBookScore(Book book, double score);

    public Book getBookByBookId(ObjectId Id);

    public Book getBookByName(String name);

    /**
     * 关键字查询
     * @param keyword 书名、类型、作者的关键字
     * @return
     */
    public List<Book> getBookByKeyword(String keyword);

    public Book getBookByIsbn(String isbn);

    public Book getBookByAuthor(String author);

    /**
     * 热门内容获取
     * 前端指定数量
     * @return
     */
    public List<Book> getBookForIndex(int num);

    public List<Book> getBookByLikeNum(int num);

}
