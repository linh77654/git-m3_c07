package com.example.baitap_ss10.repository;

import com.example.baitap_ss10.model.Students;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepository implements IStudentsRepository {
    private static List<Students> studentsList = new ArrayList<>();

    static {
        studentsList.add(new Students("SV01", "Nguyen Van A", "Nam", 85));
        studentsList.add(new Students("SV02", "Tran Thi B", "Nữ", 92));
        studentsList.add(new Students("SV03", "Le Van C", "Nam", 70));
    }

    @Override
    public List<Students> findAll() {
        return studentsList;
    }
}
