package dao;


import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImp1 implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void batchadd(List<Object[]> arg) {
        String sql="insert into t_book values(?,?,?)";
        int [] ints=jdbcTemplate.batchUpdate(sql,arg);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public List<Book> BookAll() {
        String sql="select * from t_book ";
        List<Book> books=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public Book bookInfo(String id) {
        String sql="select * from t_book where UserId=?";
        Book book= jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public int findCount() {
        String sql="select count(*) from t_book";
        int count=jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public void del(String id) {
        String sql="delete from t_book where UserId= ?";
        int count=jdbcTemplate.update(sql,id);
        System.out.println(count);
    }



    @Override
    public void add(Book book) {
        String sql="insert into t_book values(?,?,?)";
        Object o[]={book.getUserId(),book.getUserName(),book.getUstats()};
        int count=jdbcTemplate.update(sql,o);
        System.out.println(count);
    }
    @Override
    public void upd(Book book) {
        String sql="update t_book set  UserName = ? ,ustats = ? where UserId = ?";
        Object o[]={book.getUserName(),book.getUstats(),book.getUserId()};
        int count=jdbcTemplate.update(sql,o);
        System.out.println(count);
    }
}
