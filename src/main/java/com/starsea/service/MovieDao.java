package com.starsea.service;

import com.starsea.entity.Movie;
import com.starsea.enums.Region;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieDao {
    public void addMovie(Movie movie);
    public void deleteMoive(Movie movie);

    /**
     * 修改评分的同时修改评分人数
     * @param movie
     */
    public void updateMovieScore(Movie movie);

    public Movie getMovieByMovieId(ObjectId movieId);

    public Movie getMovieByName(String name, String flag);

    public Movie getMovieByDirector(String director, String flag);

    public List<Movie> getMovieByStars(String stars, String flag);

    public Movie getMovieByRegion(String region, String flag);

    public Movie getMovieByReleaseYear(int releaseYear, String flag);

    /**
     * 按关键字搜索影视
     * @param keyword
     * @param flag "true"是电影，"false"是电视剧
     * @return
     */
    public List<Movie> getMovieByKeyword(String keyword, String flag);

    /**
     * 热门内容获取
     * 前端指定数量
     * @return
     */
    public List<Movie> getMovieForIndex(int num, String flag);
}
