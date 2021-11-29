package dao;

import service.Student;

public interface StudentDao {

    //查询一个学生
    Student selectStudentById(long id);



}
