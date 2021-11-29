package test;

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;
import service.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class testBook {
    @Test
    public void testJdbcTemplateAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        for(int i=0;i<50;i++){
            Book book=new Book();
            book.setUserId(String.valueOf(Math.random()*50) );
            book.setUserName("java2");
            book.setUstats("b");
            bookService.addBook(book);
        }
    }

    @Test
    public void testJdbcTemplateUpd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        Book book=new Book();
        book.setUserId("1");
        book.setUserName("java3");
        book.setUstats("c");
        bookService.updBook(book);
    }

    @Test
    public void testJdbcTemplateDel(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        bookService.delBook("1");
    }
    @Test
    public void testJdbcTemplateCount(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.findCount());
    }
    @Test
    public void testJdbcTemplatefind(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.bookInfo("2"));
    }
    @Test
    public void testJdbcTemplatefindAll(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.BookAll());
    }
    @Test
    public void testJdbcTemplateBatchAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        List<Object []> arg=new ArrayList<>();
        Object[] o1={"5444","java","dd"};
        Object[] o2={"56334","jaba","dd"};
        Object[] o3={"5742","java","dd"};
        arg.add(o1);
        arg.add(o2);
        arg.add(o3);
        bookService.batchAdd(arg);
    }
    @Test
    public void  testSelectStudentById() throws IOException {
        //调用mybatis某个对象的方法,执行
        //mybatis核心类：sqlSessionFactory

        //1.定义mybatis主配置文件的相对路径
        String config= "student/mybatis.xml";
        //2.读取主配置文件
        InputStream inputStream= Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactory对象,使用sqlSessionFactoryBuilder类
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);

        //4.获取sqlSession对象
        SqlSession session=factory.openSession();

        //5.指定要执行的sql语句的 id
        // sql的id=namespace +"."+<select>|update|insert| 标签的id属性值
        String sqlId="dao.BookDao"+"."+"selectStudentById";

        //6.通过sqlSession的方法，执行sql语句
        Student student=session.selectOne(sqlId);
        System.out.println(student);
        session.close();

    }

}
