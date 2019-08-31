package com.starsea.vo;

import com.starsea.entity.Book;
import com.starsea.entity.Group;
import com.starsea.entity.Movie;
import com.starsea.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class AllList {
    /**
     * 搜索到的结果
     */
    Object result;
    /**
     * 记录结果类型
     * 1:图书，2：电影，3：电视剧，4：小组，5：帖子
     */
    int flag;
    /**
     * 记录评分
     */
    double score;

    public AllList(Object result) {
        this.result = result;
        if(result instanceof Book) {
            flag = 1;
            score = ((Book) result).getScore();
        }
        else if(result instanceof Movie) {
            if(((Movie) result).getFlag()=="true") {
                flag = 2;
            } else {
                flag = 3;
            }
            score = ((Movie) result).getScore();
        }
        else if(result instanceof Group) {
            flag = 4;
            double degree = ((Group) result).getHeatDegree() / 20;
            if(degree > 0.5) {
                degree = 0.5;
            }
            score = 4.3 + degree;
        }
        else if(result instanceof Post) {
            flag = 5;
            double degree = ( ((Post) result).getLikeNum() + ((Post) result).getCollectNum() ) / 20;
            if(degree > 0.5) {
                degree = 0.5;
            }
            score = 4.3 + degree;
        } else {
            flag = -1;
            score = 0;
        }
    }

    public static List<AllList> transMovieToAllList(List<Movie> lists) {
        List<AllList> allLists = new ArrayList<AllList>();
        int len = lists.size();
        for(int i=0; i<len; i++) {
            allLists.add(new AllList(lists.get(i)));
        }
        return allLists;
    }

    public static List<AllList> transBookToAllList(List<Book> lists) {
        List<AllList> allLists = new ArrayList<AllList>();
        int len = lists.size();
        for(int i=0; i<len; i++) {
            allLists.add(new AllList(lists.get(i)));
        }
        return allLists;
    }

    public static List<AllList> transGroupToAllList(List<Group> lists) {
        List<AllList> allLists = new ArrayList<AllList>();
        int len = lists.size();
        for(int i=0; i<len; i++) {
            allLists.add(new AllList(lists.get(i)));
        }
        return allLists;
    }

    public static List<AllList> transPostToAllList(List<Post> lists) {
        List<AllList> allLists = new ArrayList<AllList>();
        int len = lists.size();
        for(int i=0; i<len; i++) {
            allLists.add(new AllList(lists.get(i)));
        }
        return allLists;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
