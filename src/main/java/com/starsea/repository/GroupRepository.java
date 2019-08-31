package com.starsea.repository;

import com.starsea.entity.Group;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupRepository extends MongoRepository<Group, ObjectId> {
    public Group findByName(String name);

    public Group findByGroupId(ObjectId groupId);

    public List<Group> findByNameLike(String keyword);

    public List<Group> findByTagsLike(String tag);

    public List<Group> findByLeaderName(String leaderName);
}
