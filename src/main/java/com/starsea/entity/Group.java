package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "groups")
public class Group {
    @Id
    private ObjectId groupId;

    private String name;
    /**
     * 小组标签
     */
    private String[] tags;

    private String introduction;

    private Date date;

    private String createTime;

    private String leaderName;

    private List<String> adminsName;

    private List<String> membersName;

    private int heatDegree;

    public Group() {

    }

    @PersistenceConstructor
    public Group(String name, String[] tags, String introduction, String leaderName) {
        this.name = name;
        this.tags = tags;
        this.introduction = introduction;
        date = new Date();
        createTime = String.format("%tY年%<tm月%<td日", date);//2010年10月4日 17:31:11
        this.leaderName = leaderName;
        this.membersName = new ArrayList<String>();
        this.membersName.add(leaderName);
        heatDegree = 1;
    }

    public ObjectId getGroupId() {
        return groupId;
    }

    public void setGroupId(ObjectId groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public List<String> getAdminsName() {
        return adminsName;
    }

    public void setAdminsName(List<String> adminsName) {
        this.adminsName = adminsName;
    }

    public List<String> getMembersName() {
        return membersName;
    }

    public void setMembersName(List<String> membersName) {
        this.membersName = membersName;
    }

    public int getHeatDegree() {
        return heatDegree;
    }

    public void setHeatDegree(int heatDegree) {
        this.heatDegree = heatDegree;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", introduction='" + introduction + '\'' +
                ", date=" + date +
                ", createTime='" + createTime + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", adminsName=" + adminsName +
                ", membersName=" + membersName +
                ", heatDegree=" + heatDegree +
                '}';
    }
}
