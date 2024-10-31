package com.example.demo_jstl_c07.service;

import com.example.demo_jstl_c07.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add (Student student);
}
