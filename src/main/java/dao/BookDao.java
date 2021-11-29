package dao;

import entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void upd(Book book);
    void del(String id);
    int findCount();
    Book bookInfo(String id);
    List<Book> BookAll();
    void batchadd(List<Object[]> arg);
}
