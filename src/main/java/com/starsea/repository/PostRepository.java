package com.starsea.repository;

import com.starsea.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, ObjectId> {
    public List<Post> findByUsername(String username);

    public List<Post> findByTitleLike(String title);

    public List<Post> findByIsTop(int isTop);

    public List<Post> findByIsGreat(int isGreat);

    public Post findByPostId(ObjectId postId);

    public List<Post> findByGroupId(ObjectId groupId);
}
