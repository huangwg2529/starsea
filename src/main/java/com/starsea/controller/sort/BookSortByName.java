package com.starsea.controller.sort;

import com.starsea.entity.Book;
import org.springframework.expression.spel.CompilablePropertyAccessor;

import java.util.Comparator;

public class BookSortByName implements Comparator {
    public int compare(Object o1, Object o2) {
        Book s1 = (Book) o1;
        Book s2 = (Book) o2;
        return s1.getName().compareTo(s2.getName());
    }
}