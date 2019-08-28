package com.starsea.controller.sort;

import com.starsea.entity.Book;

import java.util.Comparator;

/**
 * 按照评分从大到小排序
 */
public class BookSortByEvaluation implements Comparator {
    public int compare(Object o1, Object o2) {
        Book s1 = (Book) o1;
        Book s2 = (Book) o2;
        if(s1.getScore() > s2.getScore()){
            return -1;
        } else if(s1.getScore() < s2.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }
}
