package com.starsea.service;

import com.starsea.entity.Group;
import com.starsea.entity.User;
import com.starsea.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupDaoImpl implements GroupDao {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GroupRepository groupRepository;

    public void addGroup(Group group) {
        groupRepository.insert(group);
    }

    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }

    public void addGroupMember(Group group, String username) {
        Query query = Query.query(Criteria.where("GroupId").is(group.getGroupId()));
        List<String> members = group.getMembersName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        members.add(username);
        Update update = new Update();
        update.set("groupMembers", members);
        System.out.println(update);
        System.out.println(query);
        mongoTemplate.updateFirst(query, update, Group.class);
    }

    public void deleteGroupMember(Group group, String username) {
        Query query = Query.query(Criteria.where("GroupId").is(group.getGroupId()));
        List<String> members = group.getMembersName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        members.remove(username);
        Update update = new Update();
        update.set("groupMembers", members);
        System.out.println(update);
        mongoTemplate.updateFirst(query, update, "groups");
    }

    public void addGroupAdmin(Group group, String username) {
        Query query = Query.query(Criteria.where("GroupId").is(group.getGroupId()));
        List<String> admins = group.getAdminsName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        admins.add(username);
        Update update = new Update();
        update.set("groupAdmins", admins);
        mongoTemplate.updateFirst(query, update, "groups");
    }

    public void deleteGroupAdmin(Group group, String username) {
        Query query = Query.query(Criteria.where("GroupId").is(group.getGroupId()));
        List<String> admins = group.getAdminsName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        admins.remove(username);
        Update update = new Update();
        update.set("groupAdmins", admins);
        mongoTemplate.updateFirst(query, update, "groups");
    }

    public void updateGroupHeatDegree(Group group) {
        System.out.println("waiting");
    }

    public Group getGroupByName(String name) {
        return groupRepository.findByName(name);
    }

    public List<Group> getGroupByKeyword(String keyword) {
        return groupRepository.findByNameLike(keyword);
    }

    public List<Group> getGroupByTag(String tag) {
        return groupRepository.findByTagsLike(tag);
    }

    public List<Group> getGroupByHeatDegree(int num) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "heatDegree");
        Query query = new Query();
        query.with(Sort.by(order)).limit(num);
        return mongoTemplate.find(query, Group.class);
    }
}
