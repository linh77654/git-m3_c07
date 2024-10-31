package com.example.demo_jstl_c07.repository;

import com.example.demo_jstl_c07.controller.StudentController;
import com.example.demo_jstl_c07.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean add (Student student);
}
