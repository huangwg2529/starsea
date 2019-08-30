package com.starsea.service;

import com.starsea.entity.Discuss;
import com.starsea.entity.Group;
import com.starsea.entity.Post;
import com.starsea.repository.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDaoImpl implements PostDao {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void addPost(Post post) {
        postRepository.insert(post);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
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


    public void updateIsTop(Post post, int isTop) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
        Update update = new Update();
        update.set("isTop", isTop);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    public void updateIsGreat(Post post, int isGreat) {
        Query query = new Query(Criteria.where("postId").is(post.getPostId()));
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
        update.set("discuss", discusses);
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

    public List<Post> getPostByTitle(String title) {
        return postRepository.findByTitleLike(title);
    }

    public List<Post> getPostByGroup(Group group) {
        return postRepository.findByGroupId(group.getGroupId());
    }

    /**
     * 获取精华帖
     * @return
     */
    public List<Post> getPostByIsGreat() {
        return postRepository.findByIsGreat(1);
    }

    /**
     * 获取置顶帖
     * @return
     */
    public List<Post> getPostByIsTop() {
        return postRepository.findByIsTop(1);
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
