package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService adminService;

    // Constructor Injection of AdminService
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Admin Login Endpoint
    @PostMapping("/adminLogin")
    public Boolean login(@RequestBody Admin admin, HttpServletRequest request) {
        Admin dataAdmin = adminService.getAdminByName(admin.getUsername());

        if (dataAdmin != null && dataAdmin.getPassword().equals(admin.getPassword())) {
            // Store the logged-in admin in session
            HttpSession session = request.getSession(); // Get or create a session
            session.setAttribute("loggedInAdmin", dataAdmin);
            System.out.println("Logged-in Admin: " + session.getAttribute("loggedInAdmin"));
            return true;
        }
        return false;
    }

    // Check Session Endpoint
    @GetMapping("/checkSessionAdmin")
    public Boolean checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
        return session != null && session.getAttribute("loggedInAdmin") != null;
    }

    // Admin Logout Endpoint
    @GetMapping("/logoutAdmin")
    public Boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session
        if (session != null) {
            session.invalidate(); // Invalidate the session
            System.out.println("Session invalidated.");
            return true;
        }
        return false;
    }
}
