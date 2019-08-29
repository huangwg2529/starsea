package com.starsea.service;

import com.starsea.entity.MovieEvaluation;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieEvaluationDao {
    public void addMovieEvaluation(MovieEvaluation movieEvaluation);

    public void deleteMovieEvaluation(MovieEvaluation movieEvaluation);

    public List<MovieEvaluation> getMovieEvaluationByUsername(String username);

    public MovieEvaluation getMovieEvaluationByMeId(ObjectId meId);

    /**
     * 获取影评
     * @param movieId
     * @param flag 1表示按点赞数，2表示按时间
     * @return
     */
    public List<MovieEvaluation> getMovieEvaluationByMovieId(ObjectId movieId, int flag);

    /**
     * 更新点赞数
     * @param movieEvaluation
     * @param flag 1为增，-1为减
     */
    public void updateLikeNum(MovieEvaluation movieEvaluation, int flag);

    /**
     * 判断某位用户是否已经给这个评论点赞
     * @param movieEvaluation
     * @param username
     * @return
     */
    public int movieEvaluationIsStar(MovieEvaluation movieEvaluation, String username);
}
