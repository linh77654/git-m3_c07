package com.example.baitap_ss10.controller;

import com.example.baitap_ss10.model.Students;
import com.example.baitap_ss10.service.IStudentsService;
import com.example.baitap_ss10.service.StudentsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "StundentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private IStudentsService studentsService = new StudentsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Students> studentsList = studentsService.getStudentsList();
        request.setAttribute("students", studentsList);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}
