package com.starsea;

import com.starsea.entity.*;
import com.starsea.service.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
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
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        Date create = new Date();
        String time = String.format("%tY年%<tm月%<td日", create) + " " + String.format("%tT", create);
        //Post(String title, String username, String imgAddr, String mainBody, String time)
        String mainBody = "只是用于测试的，所以没有25字限制";
        Post post = new Post("第一个帖子！", "hwg", "http://114.115.131.124:8666/image/book/test.png", mainBody, time);
        //postDao.addPost(post);
        //postDao.updateIsTop(post, 1);
        //Discuss(String replierName, String imgAddr, String beReplierName, String time, String mainBody)
        Discuss discuss = new Discuss("zz", "http://114.115.131.124:8666/image/book/test.png", "hwg", time, "沙发！");
        postDao.addDiscuss(postDao.getPostByIsTop().get(0), discuss);
        List<Post> posts = postDao.getPostByIsTop();
        for(int i=0; i<posts.size(); i++) {
            System.out.println(posts.get(i).getDiscuss().get(0).getMainBody());
        }
         */

        Book yourname = bookDao.getBookByName("数学分析原理");
        /*
        //BookEvaluation(String username, String isbn, double score, String evaluation)

        BookEvaluation bookEvaluation1 = new BookEvaluation("hwg", yourname.getIsbn(), 4.2, "这只是测试用的啊");
        BookEvaluation bookEvaluation2 = new BookEvaluation("hwg", yourname.getIsbn(), 4.2, "这只是测试用的啊啊");
        BookEvaluation bookEvaluation3 = new BookEvaluation("hwg", yourname.getIsbn(), 4.2, "这只是测试用的啊啊啊");

        bookEvaluationDao.addBookEvaluation(bookEvaluation1);
        bookEvaluationDao.addBookEvaluation(bookEvaluation2);
        bookEvaluationDao.addBookEvaluation(bookEvaluation3);

        List<BookEvaluation> bes = bookEvaluationDao.getBookEvaluationByIsbn(yourname.getIsbn(), 1);
        for(int i=0; i<bes.size(); i++) {
            System.out.println(bes.get(i).getLikeNum() + bes.get(i).getTime() + bes.get(i).getEvaluation());
        }
        bes = bookEvaluationDao.getBookEvaluationByIsbn(yourname.getIsbn(), 2);
        for(int i=0; i<bes.size(); i++) {
            System.out.println(bes.get(i).getLikeNum() + bes.get(i).getTime() + bes.get(i).getEvaluation());
        }
         */

        /*
        List<Movie> movies = movieDao.getMovieByKeyword("", "true");
        for(int i=0; i<movies.size(); i++) {
            System.out.println(movies.get(i).getName() + movies.get(i).getScore());
        }
         */






        /*
        ObjectId id = new ObjectId("5d64ea209107400a443a342a");
        String ids = id.toString();
        System.out.println("ObjectId: " + id);
        System.out.println("String:  " + ids);
        ObjectId ider = new ObjectId(ids);
        System.out.println(ider.equals(id));
         */

        /*
        Date now = new Date();
        String createTime = String.format("%tY-%<tm-%<td", now);  //2010-10-4
        String createTime2 = String.format("%tY年%<tm月%<td日", now) + " " + String.format("%tT", now);//2010年10月4日 17:31:11
        System.out.println(createTime + "   " + createTime2);
         */

        /**
         * 小组测试
        User creater = new User("huang", "huang");

        String[] tags = {"MIUI", "校园"};
        //Group(String name, String[] tags, String introduction, String createTime, User groupLeader)
        Group group = new Group("MIUI校园俱乐部", tags, "这里是北航MIUI校园俱乐部", createTime, creater);
        //groupDao.addGroup(group);
        List<Group> groups = groupDao.getGroupByTag("MIUI");
        for(int i=0; i<groups.size(); i++) {
            System.out.println(groups.get(i).getName());
        }
        List<Group> groups1 = groupDao.getGroupByKeyword("MI");
        for(int i=0; i<groups.size(); i++) {
            System.out.println(groups1.get(i).getName());
        }
        //groupDao.addGroupMember(groupDao.getGroupByName("MIUI校园俱乐部"), userDao.getUserByName("zz"));

        //groupDao.addGroupMember(groupDao.getGroupByName("MIUI校园俱乐部"), "zz");
        List<Movie> movie = movieDao.getMovieByKeyword("寄", "true");
        //System.out.println(movie.get(0));
        movieDao.updateMovieScore(movie.get(0));
         */

        /**
         * 测试关键字查询
        List<Book> books = bookDao.getBookByKeyword("");
        for(int i=0; i<books.size(); i++){
            System.out.println("name:" + books.get(i).getName() + "   author:" + books.get(i).getAuthor());
        }
         */

        /**
         * 添加影评
        Movie movie = movieDao.getMovieByName("流浪地球");
        MovieEvaluation movieEvaluation = new MovieEvaluation("1", movie.getMovieId(), 4.5, "超好看的");
        MovieEvaluation movieEvaluation1 = new MovieEvaluation("zz", movie.getMovieId(), 5.0, "超好看的啊");
        movieEvaluationDao.addMovieEvaluation(movieEvaluation);
        movieEvaluationDao.addMovieEvaluation(movieEvaluation1);
        movieDao.updateMovieScore(movie);
        bookDao.updateBookScore(bookDao.getBookByName("mathbook"));
         */

        /**
        List<Book> books = bookDao.getBookByKeyword("数");
        Collections.sort(books, new BookSortByEvaluation());
        for(int i=0; i<books.size(); i++) {
            System.out.println("book:" + books.get(i).getName() + "  score:" + books.get(i).getScore());
        }

        System.out.println("init finished");
        */

        /**
        BookType[] types = {BookType.EDUCATION};
        //Book(String isbn, String name, String author, String publishingCompany, int releaseYear, Region region, String language, BookType[] bookTypes, String imgAddr, int price, String introduction)
        Book math = new Book("111121111", "mathbook", "李尚志", "高等教育出版社", 2015, Region.CHINESE_MAINLAND, "中文", types, "image/book/mathbook.png", 59.9, "这是一本数学书");
        bookDao.addBook(math);
        movieDao.updateMovieScore(movieDao.getMovieByName("寄生虫"));
        bookDao.updateBookScore(bookDao.getBookByName("mathbook"));
        System.out.println("init finished");
        */

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