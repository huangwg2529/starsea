package com.starsea.service;

import com.starsea.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookDao {
    //用户只能查询，不能增删改
    public void addBook(Book book);
    public void deleteBook(Book book);
    public void updateBook(Book book);

    public void updateBookScore(Book book);

    public Book getBookByName(String name);

    public List<Book> getBookByKeyword(String keyword);

    public Book getBookByIsbn(String isbn);

    public Book getBookByAuthor(String author);

}
