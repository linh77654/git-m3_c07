package com.example.demo_jstl_c07.repository;

import com.example.demo_jstl_c07.model.Clazz;

import java.util.List;

public interface IClassRepository {
    List<Clazz> findAll();
}
