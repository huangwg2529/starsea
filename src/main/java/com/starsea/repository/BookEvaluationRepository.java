package com.starsea.repository;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookEvaluationRepository extends MongoRepository<BookEvaluation, ObjectId> {
    public List<BookEvaluation> findByIsbn(String isbn);
    public List<BookEvaluation> findByUsername(String username);
    public BookEvaluation findByBeId(ObjectId beId);
}
