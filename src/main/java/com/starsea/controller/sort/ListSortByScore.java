package com.starsea.controller.sort;

import com.starsea.vo.AllList;

import java.util.Comparator;

/**
 * 按照评分从大到小排序
 */
public class ListSortByScore implements Comparator {
    public int compare(Object o1, Object o2) {
        AllList s1 = (AllList) o1;
        AllList s2 = (AllList) o2;
        if(s1.getScore() > s2.getScore()){
            return -1;
        } else if(s1.getScore() < s2.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }
}