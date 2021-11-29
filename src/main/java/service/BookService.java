package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED)//可以在类上面也可以在方法上面，在类上面，这个类的所有方法都添加事务
//REQUIRED 如果有事务在运行，当前的方法在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行
//REQUIRED_NEW当前的方法必须启动新事务，并在它自己的事务内运行，如果有事务正在运行，应该将他挂起
//SUPPORTS 如果有事务在运行，当前的方法就在这个事务内运行，否则他可以不运行在事务中
public class BookService {


    //注入dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }
    public void updBook(Book book){
        bookDao.upd(book);
    }
    public void delBook(String id){
        bookDao.del(id);
    }
    public int findCount(){
        return  bookDao.findCount();
    }
    public Book bookInfo(String id){
        return bookDao.bookInfo(id);
    }
    public List<Book> BookAll(){
        return bookDao.BookAll();
    }
    public void batchAdd(List<Object[]> book){
        bookDao.batchadd(book);
    }
}
