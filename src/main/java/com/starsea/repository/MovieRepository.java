package com.starsea.repository;

import com.starsea.entity.Movie;
import com.starsea.enums.Region;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    public Movie findByName(String name);

    public Movie findByNameAndFlag(String name, boolean flag);

    public Movie findByDirectorAndFlag(String director, boolean flag);

    public Movie findByDirector(String director, boolean flag);

    public Movie findByRegion(String region);

    public Movie findByRegionAndFlag(String region, boolean flag);

    public Movie findByReleaseYear(int releaseYear);

    public Movie findByReleaseYearAndAndFlag(int releaseYear, boolean flag);

    public List<Movie> findByNameLike(String name);

    public List<Movie> findByNameLikeAndFlag(String name, boolean flag);

    public List<Movie> findByStars(String stars);

    public List<Movie> findByStarsAndFlag(String stars, boolean flag);
}
