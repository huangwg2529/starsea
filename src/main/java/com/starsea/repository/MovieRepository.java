package com.starsea.repository;

import com.starsea.entity.Movie;
import com.starsea.enums.Region;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    public Movie findByName(String name);

    public Movie findByDirector(String director);

    public Movie findByRegion(Region region);

    public Movie findByReleaseYear(int releaseYear);

    public List<Movie> findByNameLike(String name);

    public List<Movie> findByStars(String stars);
}
