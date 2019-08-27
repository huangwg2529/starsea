package com.starsea.service;

import com.starsea.entity.Movie;
import com.starsea.enums.Region;
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

    public Movie getMovieByName(String name);

    public Movie getMovieByDirector(String director);

    public List<Movie> getMovieByStars(String stars);

    public Movie getMovieByRegion(Region region);

    public Movie getMovieByReleaseYear(int releaseYear);

    public List<Movie> getMovieByKeyword(String keyword);
}
