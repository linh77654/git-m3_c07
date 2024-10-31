package com.example.demo_jstl_c07.repository;

import com.example.demo_jstl_c07.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final static String SELECT_ALL ="select * from student;";
    private final static String ADD_NEW ="insert into student(name,gender,point,class_id) value (?,?,?,?)";
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"chánh",true,5.0f,1));
        students.add(new Student(2,"chánh2",false,8.0f,1));
        students.add(new Student(3,"chánh3",true,10.0f,1));
        students.add(new Student(4,"chánh4",false,4.0f,1));
        students.add(new Student(5,"chánh5",true,5.0f,1));
        students.add(new Student(6,"chánh6",true,5.0f,1));
    }
    @Override
    public List<Student> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Student> studentList = new ArrayList<>();
         try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from student");
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               boolean gender = resultSet.getBoolean("gender");
               float point = resultSet.getFloat("point");
               int classId = resultSet.getInt("class_id");
               Student student = new Student(id,name,gender,point,classId);
               studentList.add(student);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
       Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setBoolean(2, student.isGender());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setInt(4, student.getClassId());
            int row = preparedStatement.executeUpdate();
            return row==1;
        } catch (SQLException e) {
            System.out.println("lỗi");
            return false;
        }
    }
}
