package com.starsea;

import com.starsea.entity.Book;
import com.starsea.entity.BookEvaluation;
import com.starsea.entity.Movie;
import com.starsea.entity.MovieEvaluation;
import com.starsea.enums.Region;
import com.starsea.enums.Type;
import com.starsea.service.BookDao;
import com.starsea.service.BookEvaluationDao;
import com.starsea.service.MovieDao;
import com.starsea.service.MovieEvaluationDao;
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
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieEvaluationDao movieEvaluationDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 测试关键字查询
        List<Book> books = bookDao.getBookByKeyword("");
        for(int i=0; i<books.size(); i++){
            System.out.println("name:" + books.get(i).getName() + "   author:" + books.get(i).getAuthor());
        }
         */

        movieDao.updateMovieScore(movieDao.getMovieByName("寄生虫"));
        bookDao.updateBookScore(bookDao.getBookByName("mathbook"));
        System.out.println("init finished");


        /**
         * 测试影视数据库
        String stars = "宋康昊 / 李善均 / 赵汝贞 / 崔宇植 / 朴素";
        Type[] types = {Type.COMEDY, Type.PLOT};
        String introduction = "《寄生虫》讲述了发生在身份地位悬殊的两个家庭身上的故事：宋康昊饰演的无业游民父亲基泽，让寄托了家人生计希望的大儿子（崔宇植 饰）前往IT公司老总朴社长（李善均 饰）家应聘课外教师，随之发生了一连串意外事件。";
        Movie movie = new Movie("寄生虫", "奉俊昊", stars, types, Region.KOREA, 2019, introduction);
        movieDao.addMovie(movie);
        Movie thismovie = movieDao.getMovieByName("寄生虫");
        //MovieEvaluation(String username, ObjectId movieId, double score, String evaluation)
        MovieEvaluation movieEvaluation = new MovieEvaluation("1", thismovie.getMovieId(), 4.0, "很好看啊");
        MovieEvaluation movieEvaluation1 = new MovieEvaluation("zz", thismovie.getMovieId(), 4.5, "超好看的");
        movieEvaluationDao.addMovieEvaluation(movieEvaluation);
        movieEvaluationDao.addMovieEvaluation(movieEvaluation1);
        movieDao.updateMovieScore(thismovie);
        System.out.println("init finished");
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