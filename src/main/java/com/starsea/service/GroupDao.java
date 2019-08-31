package com.starsea.service;

import com.starsea.entity.Group;
import com.starsea.entity.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupDao {
    /**
     * 创建小组
     */
    public void addGroup(Group group);

    public void deleteGroup(Group group);

    /**
     * 新增小组成员
     * @param group
     * @param username
     */
    public void addGroupMember(Group group, String username);
    /**
     * 删除小组成员
     */
    public void deleteGroupMember(Group group, String username);

    /**
     * 组长添加小组管理员
     * @param group
     * @param username
     */
    public void addGroupAdmin(Group group, String username);

    /**
     * 组长撤销管理员
     */
    public void deleteGroupAdmin(Group group, String username);

    /**
     * 修改小组热度
     * @param group
     * @param flag 1和-1
     */
    public void updateGroupHeatDegree(Group group, int flag);

    public Group getGroupByName(String name);

    public List<Group> getGroupByKeyword(String keyword);

    public List<Group> getGroupByTag(String tag);

    public List<Group> getGroupByHeatDegree(int num);

    public Group getGroupByGroupId(ObjectId groupId);

    public boolean isJoinGroup(ObjectId groupId, String username);

    public int isGroupAdmin(ObjectId groupId, String username);

    public List<Group> getGroupICreated(String username);


}
