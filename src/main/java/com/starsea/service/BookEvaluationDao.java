package com.starsea.service;

import com.starsea.entity.BookEvaluation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookEvaluationDao {
    public void addBookEvaluation(BookEvaluation bookEvaluation);

    public void deleteBookEvaluation(BookEvaluation bookEvaluation);

    public List<BookEvaluation> getBookEvaluationByUsername(String username);

    public List<BookEvaluation> getBookEvaluationByIsbn(String isbn);
}
