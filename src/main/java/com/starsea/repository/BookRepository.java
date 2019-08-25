package com.starsea.repository;

import com.starsea.entity.Book;
import com.starsea.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {
    public Book findByName(String name);
    public Book findByAuthor(String author);
    public Book findByIsbn(String isbn);

}
