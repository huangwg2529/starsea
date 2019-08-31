package com.starsea.service;

import com.starsea.entity.Discuss;
import com.starsea.entity.Group;
import com.starsea.entity.Post;
import com.starsea.repository.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@Service
public class PostDaoImpl implements PostDao {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;

    public void addPost(Post post) {
        postRepository.insert(post);
        Group group = groupDao.getGroupByGroupId(post.getGroupId());
        //热度+1
        groupDao.updateGroupHeatDegree(group, 1);
        //添加进个人主页的”我的帖子“
        userDao.updateMyPosts(post.getUsername(), post.getPostId(), 1);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
        Group group = groupDao.getGroupByGroupId(post.getGroupId());
        //热度-1
        groupDao.updateGroupHeatDegree(group, -1);
        userDao.updateMyPosts(post.getUsername(), post.getPostId(), -1);
    }

    public void updateLikeNum(Post post, int flag) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        update.set("likeNum", post.getLikeNum() + flag);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void updateCollectNum(Post post, int flag) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        update.set("collectNum", post.getCollectNum() + flag);
        mongoTemplate.updateFirst(query, update, Post.class);
    }


    public void updateIsTop(Post post) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        int isTop = post.getIsTop();
        if(isTop == 0) {
            isTop = 1;
        } else {
            isTop = 0;
        }
        Update update = new Update();
        update.set("isTop", isTop);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void updateIsGreat(Post post) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        int isGreat = post.getIsGreat();
        if(isGreat == 0) {
            isGreat = 1;
        } else {
            isGreat = 0;
        }
        Update update = new Update();
        update.set("isGreat", isGreat);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void addDiscuss(Post post, Discuss discuss) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        List<Discuss> discusses = post.getDiscuss();
        int count = discusses.size();
        discuss.setDiscussId(count + 1);
        discusses.add(discuss);
        //修改最新回复时间
        Date replyDate = new Date();
        String time = String.format("%tY年%<tm月%<td日", replyDate) + " " + String.format("%tT", replyDate);
        update.set("discuss", discusses);
        update.set("replyDate", replyDate);
        update.set("replyTime", time);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void deleteDiscuss(Post post, Discuss discuss) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        List<Discuss> discusses = post.getDiscuss();
        discusses.remove(discuss);
        update.set("discuss", discusses);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void updateDiscussLikeNum(Post post, int discussId, int flag) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        List<Discuss> discusses = post.getDiscuss();
        int count = discusses.get(discussId).getLikeNum();
        discusses.get(discussId).setLikeNum(count + flag);
        update.set("discuss", discusses);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public List<Post> getPostByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    public List<Post> getPostByTitleLike(String title) {
        return postRepository.findByTitleLike(title);
    }

    public List<Post> getPostByGroup(Group group, int flag, int num) {
        Sort.Order order;
        if(flag == 1) {
            order = new Sort.Order(Sort.Direction.DESC, "createDate");
        } else if(flag == 2) {
            order = new Sort.Order(Sort.Direction.DESC, "likeNum");
        } else {
            order = new Sort.Order(Sort.Direction.DESC, "replyDate");
        }
        Query query = new Query(Criteria.where("groupId").is(group.getGroupId()));
        query.with(Sort.by(order)).limit(num);
        return mongoTemplate.find(query, Post.class);
    }

    public List<Post> getPostByKeyword(String keyword) {
        return postRepository.findByTitleLike(keyword);
    }

    public List<Post> getPostByHeatDegree(int num) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "likeNum");
        Query query = new Query();
        query.with(Sort.by(order)).limit(num);
        return mongoTemplate.find(query, Post.class);
    }


    /**
     * 获取精华帖
     * @return
     */
    public List<Post> getPostByIsGreat(Group group) {
        Query query = new Query();
        query.addCriteria(Criteria.where("groupId").is(group.getGroupId()));
        query.addCriteria(Criteria.where("isGreat").is(1));
        return mongoTemplate.find(query, Post.class);
    }

    /**
     * 获取置顶帖
     * @return
     */
    public List<Post> getPostByIsTop(Group group) {
        Query query = new Query();
        query.addCriteria(Criteria.where("groupId").is(group.getGroupId()));
        query.addCriteria(Criteria.where("isTop").is(1));
        return mongoTemplate.find(query, Post.class);
    }

    public Post getPostById(ObjectId id) {
        return postRepository.findByPostId(id);
    }

    /**
     * 查询一个属性的子属性，例如：查下面数据的key2.keyA的语句
     *
     *  var s = {
     *        key1: value1,
     *        key2: {
     *            keyA: valueA,
     *            keyB: valueB
     *        }
     *    };
     *
     * @Query("{'key2.keyA':?0}")
     * List<Asset> findAllBykeyA(String keyA);
     */
}
