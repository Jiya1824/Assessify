package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminLoginRequest;
import com.example.demo.entity.Student;
import com.example.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection of StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get All Students
    @GetMapping("/Allstudent")
    public List<Student> listStudents() {
        return studentService.getAllStudents(); 
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        // Logic to retrieve students
        return studentService.getAllStudents();
    }

    // Create a New Student
    @PostMapping("/createStudent")
    public Student newStudent(@RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }

    // Student Login
    @PostMapping("/studentLogin")
public Boolean login(@RequestBody Student student, HttpServletRequest request) {
    // Fetch the student by phone number
    Student dataStudent = studentService.getStudentByphone(student.getphone());

    // Check if the student exists and the password matches
    if (dataStudent != null && dataStudent.getPassword().equals(student.getPassword())) {
        // Store the logged-in student in session
        HttpSession session = request.getSession(); // Get or create a session
        session.setAttribute("loggedInStudent", dataStudent); // Store the student in session
        System.out.println("Logged-in Student: " + session.getAttribute("loggedInStudent"));
        return true;
    }
    return false; // If login fails, return false
}

    // Check Admin Credentials
    @PostMapping("/checkAdmin")
    public Boolean checkAdmin(@RequestBody AdminLoginRequest loginRequest) {
        // Fetch the user who is an admin using a role or username
        Student admin = studentService.getAdminByUsername(loginRequest.getUsername());

        // If the user is found and the password matches, return true
        return admin != null && admin.getPassword().equals(loginRequest.getPassword());
    }


    // Check if Student is Logged In (Session Check)
    @GetMapping("/checkSession")
    public Boolean checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
        return session != null && session.getAttribute("loggedInStudent") != null;
    }

    // Logout Student
    @GetMapping("/logout")
    public Boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session
        if (session != null) {
            session.invalidate(); // Invalidate the session
            System.out.println("Session invalidated.");
            return true;
        }
        return false;
    }

    // Get Student Name by Phone Number
    @GetMapping("/student/{phone}")
    public ResponseEntity<String> getName(@PathVariable String phone) {
        String name = studentService.getName(phone);
        if (name != null) {
            return ResponseEntity.ok().body("{\"name\": \"" + name + "\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Student not found\"}");
        }
    }
}



