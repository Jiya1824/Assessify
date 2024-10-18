package com.example.demo.dto;
import java.util.Objects;

public class AdminLoginRequest {
    
    // Fields
    private String username;
    private String password;

    // Default Constructor (required for Spring to automatically bind data)
    public AdminLoginRequest() {
    }

    // Parameterized Constructor (optional, but useful)
    public AdminLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: Override toString, equals, and hashCode (good for debugging and comparisons)
    @Override
    public String toString() {
        return "AdminLoginRequest [username=" + username + ", password=" + password + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AdminLoginRequest that = (AdminLoginRequest) obj;
        return username.equals(that.username) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
