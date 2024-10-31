package com.example.demo_jstl_c07.service;

import com.example.demo_jstl_c07.model.Student;
import com.example.demo_jstl_c07.repository.IStudentRepository;
import com.example.demo_jstl_c07.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        //  validate trước khi thêm mới
       return studentRepository.add(student);
    }
}
