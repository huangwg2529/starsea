package com.starsea.service;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.repository.BookEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEvaluationDaoImpl implements BookEvaluationDao {
    @Autowired
    private BookEvaluationRepository bookEvaluationRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void addBookEvaluation(BookEvaluation bookEvaluation) {
        bookEvaluationRepository.insert(bookEvaluation);
        //新增评论的同时更新评分
    }

    public void deleteBookEvaluation(BookEvaluation bookEvaluation) {
        bookEvaluationRepository.delete(bookEvaluation);
    }

    public List<BookEvaluation> getBookEvaluationByUsername(String username) {
        return mongoTemplate.find(new Query(Criteria.where("username").is(username)), BookEvaluation.class);
    }

    public List<BookEvaluation> getBookEvaluationByIsbn(String isbn, int flag) {
        Sort.Order order;
        if(flag == 1) {
            order = new Sort.Order(Sort.Direction.DESC, "likeNum");
        } else {
            order = new Sort.Order(Sort.Direction.DESC, "date");
        }
        Query query = new Query(Criteria.where("isbn").is(isbn));
        query.with(Sort.by(order));
        return mongoTemplate.find(query, BookEvaluation.class);
    }

    @Override
    public void updateLikeNum(BookEvaluation bookEvaluation, int flag) {
        Query query = new Query(Criteria.where("beId").is(bookEvaluation.getBeId()));
        Update update = new Update();
        update.set("likeNum", bookEvaluation.getLikeNum()+flag);
        mongoTemplate.updateFirst(query, update, BookEvaluation.class);
    }
}

/*
//多个条件查询(格式1)
	public List<SysUser> findList(){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("秦岚"));
		query.addCriteria(Criteria.where("phone").is("12222222222"));
		List<SysUser> findList = mongoTemplate.find(query, SysUser.class,"userList");
		return findList;
	}
 */