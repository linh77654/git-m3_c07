package com.example.baitap_ss10.service;

import com.example.baitap_ss10.model.Students;
import com.example.baitap_ss10.repository.IStudentsRepository;
import com.example.baitap_ss10.repository.StudentsRepository;

import java.util.List;

public class StudentsService implements IStudentsService {
    private IStudentsRepository studentsRepository = new StudentsRepository();

    @Override
    public List<Students> getStudentsList() {
        return studentsRepository.findAll();
    }
}
