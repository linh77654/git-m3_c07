package com.example.baitap_ss10.repository;

import com.example.baitap_ss10.model.Students;

import java.util.List;

public interface IStudentsRepository {
    List<Students> findAll();
}
