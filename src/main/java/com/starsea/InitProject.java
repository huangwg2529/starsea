package com.starsea;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.service.BookDao;
import com.starsea.service.BookEvaluationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitProject implements ApplicationRunner {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookEvaluationDao bookEvaluationDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 测试关键字查询
        List<Book> books = bookDao.getBookByKeyword("");
        for(int i=0; i<books.size(); i++){
            System.out.println("name:" + books.get(i).getName() + "   author:" + books.get(i).getAuthor());
        }
         */



        /**
         * 测试评论
        Book math = new Book("111121111", "mathbook", "李尚志", "mathbook.png", 100, "这是一本数学书");
        //bookDao.addBook(math);
        BookEvaluation bookEvaluation = new BookEvaluation("1", "111121111", 3.5, "尚志爷，好书啊！");
        bookEvaluationDao.addBookEvaluation(bookEvaluation);
        bookDao.updateBookScore(math);
        System.out.println("init");

         */
    }
}