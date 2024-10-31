package com.example.demo_jstl_c07.service;

import com.example.demo_jstl_c07.model.Clazz;
import com.example.demo_jstl_c07.repository.ClassRepository;
import com.example.demo_jstl_c07.repository.IClassRepository;

import java.util.List;

public class ClassService implements IClassService{
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<Clazz> findAll() {
        return classRepository.findAll();
    }
}
