package com.starsea.service;

import com.starsea.entity.Discuss;
import com.starsea.entity.Group;
import com.starsea.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostDao {
    public void addPost(Post post);

    public void deletePost(Post post);

    //改
    /**
     * 更新点赞数
     * 1和-1
     */
    public void updateLikeNum(Post post, int flag);

    /**
     * 更新收藏数
     * @param post
     * @param flag 1和-1
     */
    public void updateCollectNum(Post post, int flag);

    /**
     * 设置是否置顶
     * @param post
     * @param isTop 0和1
     */
    public void updateIsTop(Post post, int isTop);

    /**
     * 设置是否精华
     * 0和1
     */
    public void updateIsGreat(Post post, int isGreat);

    //修改评论区
    public void addDiscuss(Post post, Discuss discuss);

    public void deleteDiscuss(Post post, Discuss discuss);

    /**
     * 修改评论区点赞数
     * @param post
     * @param discussId 相当于几楼吧
     * @param flag 1和-1
     */
    public void updateDiscussLikeNum(Post post, int discussId, int flag);

    //查
    public List<Post> getPostByUsername(String username);

    public List<Post> getPostByTitleLike(String title);

    /**
     * 获取小组的帖子
     * @param group 指定小组
     * @param flag 排序，1是按发帖时间，2是按热度，3是按最近回复时间
     * @param num 指定数量
     * @return
     */
    public List<Post> getPostByGroup(Group group, int flag, int num);

    public List<Post> getPostByKeyword(String keyword);

    public List<Post> getPostByHeatDegree(int num);

    /**
     * 获取精华帖
     * @return
     */
    public List<Post> getPostByIsGreat(Group group);

    /**
     * 获取置顶帖
     * @return
     */
    public List<Post> getPostByIsTop(Group group);

    public Post getPostById(ObjectId id);
}
