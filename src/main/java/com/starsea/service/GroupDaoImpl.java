package com.starsea.service;

import com.starsea.entity.Group;
import com.starsea.repository.GroupRepository;
import org.bson.types.ObjectId;
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
        Query query = Query.query(Criteria.where("groupId").is(group.getGroupId()));
        List<String> members = group.getMembersName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        members.add(username);
        Update update = new Update();
        update.set("membersName", members);
        mongoTemplate.updateFirst(query, update, Group.class);
        //热度+1
        updateGroupHeatDegree(group, 1);
        //更新个人主页
        userDao.updateMyGroups(username, group.getGroupId(), 1);
    }

    public void deleteGroupMember(Group group, String username) {
        Query query = Query.query(Criteria.where("GroupId").is(group.getGroupId()));
        List<String> members = group.getMembersName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        members.remove(username);
        Update update = new Update();
        update.set("membersName", members);
        mongoTemplate.updateFirst(query, update, "groups");
        //热度-1
        updateGroupHeatDegree(group, -1);
        userDao.updateMyGroups(username, group.getGroupId(), -1);
    }

    public void addGroupAdmin(Group group, String username) {
        Query query = Query.query(Criteria.where("groupId").is(group.getGroupId()));
        List<String> admins = group.getAdminsName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        admins.add(username);
        Update update = new Update();
        update.set("adminsName", admins);
        mongoTemplate.updateFirst(query, update, "groups");
    }

    public void deleteGroupAdmin(Group group, String username) {
        Query query = Query.query(Criteria.where("groupId").is(group.getGroupId()));
        List<String> admins = group.getAdminsName();
        if(userDao.getUserByName(username)==null) {
            return;
        }
        admins.remove(username);
        Update update = new Update();
        update.set("groupAdmins", admins);
        mongoTemplate.updateFirst(query, update, "groups");
    }

    public void updateGroupHeatDegree(Group group, int flag) {
        Query query = Query.query(Criteria.where("groupId").is(group.getGroupId()));
        Update update = new Update();
        update.set("heatDegree", group.getHeatDegree() + flag);
        mongoTemplate.updateFirst(query, update, Group.class);
    }

    @Override
    public Group getGroupByGroupId(ObjectId groupId) {
        return groupRepository.findByGroupId(groupId);
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

    public List<Group> getGroupICreated(String username) {
        return groupRepository.findByLeaderName(username);
    }

    public boolean isJoinGroup(ObjectId groupId, String username) {
        Group group = getGroupByGroupId(groupId);
        List<String> membersName = group.getMembersName();
        return membersName.contains(username);
    }

    public int isGroupAdmin(ObjectId groupId, String username) {
        Group group = getGroupByGroupId(groupId);
        List<String> adminsName = group.getAdminsName();
        if(adminsName.contains(username)) {
            return 1;
        } else if(group.getLeaderName().equals(username)) {
            return 2;
        } else {
            return 0;
        }
    }

}
