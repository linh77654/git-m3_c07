package com.example.demo_jstl_c07.controller;


import com.example.demo_jstl_c07.model.Student;
import com.example.demo_jstl_c07.service.ClassService;
import com.example.demo_jstl_c07.service.IClassService;
import com.example.demo_jstl_c07.service.IStudentService;
import com.example.demo_jstl_c07.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {

    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
               showAddForm(req, resp);
                break;
            default:
                showList(req,resp);
        }

    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("studentList", studentService.findAll());
        try {
            req.getRequestDispatcher("views/student/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("classList",classService.findAll());
            req.getRequestDispatcher("/views/student/add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                saveStudent(req,resp);
                break;
            case "delete" :
                deletStudent(req,resp);
                break;
            default:
        }
    }

    private void deletStudent(HttpServletRequest req, HttpServletResponse resp) {

        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        System.out.println("id: "+ deleteId);
    }

    private void saveStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float point = Float.parseFloat(req.getParameter("point"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name,gender,point, classId);
        studentService.add(student);
        try {
            resp.sendRedirect("/students");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
