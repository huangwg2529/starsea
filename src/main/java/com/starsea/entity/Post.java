package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 帖子
 * 所属小组、标题、正文(>25)、发帖人、时间、赞、收藏、置顶/精华
 */
@Document(collection = "posts")
public class Post {
    @Id
    private ObjectId postId;

    private ObjectId groupId;

    private String title;

    private String username;
    /**
     * 用户头像
     */
    private String imgAddr;

    /**
     * 正文（不小于25）
     */
    private String mainBody;

    private Date createDate;

    private String time;

    private int likeNum;

    private int collectNum;

    /**
     * 是否置顶
     * 0和1
     */
    private int isTop;

    /**
     * 是否精华
     * 0和1
     */
    private int isGreat;

    /**
     * 帖子下的评论回复
     */
    private List<Discuss> discuss;

    private Date replyDate;

    /**
     * 最新回复时间
     */
    private String replyTime;

    public Post() {

    }

    @PersistenceConstructor
    public Post(ObjectId groupId, String title, String username, String imgAddr, String mainBody) {
        this.groupId = groupId;
        this.title = title;
        this.username = username;
        this.imgAddr = imgAddr;
        this.mainBody = mainBody;
        createDate = new Date();
        time = String.format("%tY年%<tm月%<td日", createDate) + " " + String.format("%tT", createDate);//2010年10月4日 17:31:11
        likeNum = 0;
        collectNum = 0;
        isGreat = 0;
        isTop = 0;
        discuss = new ArrayList<Discuss>();
    }

    public ObjectId getPostId() {
        return postId;
    }

    public void setPostId(ObjectId postId) {
        this.postId = postId;
    }

    public ObjectId getGroupId() {
        return groupId;
    }

    public void setGroupId(ObjectId groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getIsGreat() {
        return isGreat;
    }

    public void setIsGreat(int isGreat) {
        this.isGreat = isGreat;
    }

    public List<Discuss> getDiscuss() {
        return discuss;
    }

    public void setDiscuss(List<Discuss> discuss) {
        this.discuss = discuss;
    }

    public String getName() {
        return title;
    }
}
