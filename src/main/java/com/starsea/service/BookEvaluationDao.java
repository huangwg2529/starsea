package com.starsea.service;

import com.starsea.entity.BookEvaluation;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookEvaluationDao {
    public void addBookEvaluation(BookEvaluation bookEvaluation);

    public void deleteBookEvaluation(BookEvaluation bookEvaluation);

    public List<BookEvaluation> getBookEvaluationByUsername(String username);

    public BookEvaluation getBookEvaluationByBeId(ObjectId beId);

    /**
     * 获取书评
     * @param isbn
     * @param flag 1表示按点赞数，2表示按时间
     * @return
     */
    public List<BookEvaluation> getBookEvaluationByIsbn(String isbn, int flag);

    /**
     * 更新点赞数
     * @param bookEvaluation
     * @param flag 1为增，-1为减
     */
    public void updateLikeNum(BookEvaluation bookEvaluation, String username, int flag);

    /**
     * 判断某位用户是否已经给这个评论点赞
     * @param bookEvaluation
     * @param username
     * @return
     */
    public int bookEvaluationIsStar(BookEvaluation bookEvaluation, String username);
}
