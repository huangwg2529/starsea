package com.starsea.vo;

/**
 * 用户(取消)点赞收藏帖子
 * 1，-1
 */
public class OperatePost {
    String postId;

    String username;

    int flag;

    public OperatePost() {

    }

    public OperatePost(String postId, String username, int flag) {
        this.postId = postId;
        this.username = username;
        this.flag = flag;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
