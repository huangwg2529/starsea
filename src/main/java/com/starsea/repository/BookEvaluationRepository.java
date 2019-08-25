package com.starsea.repository;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookEvaluationRepository extends MongoRepository<BookEvaluation, ObjectId> {
    public BookEvaluation findByIsbn(String isbn);
    public BookEvaluation findByUsername(String username);
}
