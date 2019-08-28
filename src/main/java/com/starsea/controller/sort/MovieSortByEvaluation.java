package com.starsea.controller.sort;

import com.starsea.entity.Movie;

import java.util.Comparator;

public class MovieSortByEvaluation implements Comparator {
    public int compare(Object o1, Object o2) {
        Movie s1 = (Movie) o1;
        Movie s2 = (Movie) o2;
        if(s1.getScore() > s2.getScore()){
            return -1;
        } else if(s1.getScore() < s2.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }
}
