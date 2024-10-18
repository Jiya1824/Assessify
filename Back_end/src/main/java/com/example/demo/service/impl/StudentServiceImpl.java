package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentByPhone(String phone) {
        // Assuming you have a method in StudentRepository: findByPhone
        Optional<Student> studentOptional = studentRepository.findByPhone(phone);
        return studentOptional.orElse(null); // Return null if student not found
    }

    // Corrected method: Added the missing type for the parameter `phone`
    public String getName(String phone) {
        // Assuming you have a method in StudentRepository: findByPhone
        Optional<Student> studentOptional = studentRepository.findByPhone(phone);
        return studentOptional.map(Student::getFirstName).orElse(null); // Return null if student not found
    }

    @Override
    public Student getAdminByUsername(String username) {
        // This method is unimplemented, so you can either leave it unimplemented
        throw new UnsupportedOperationException("Unimplemented method 'getAdminByUsername'");
    }

    @Override
    public Student getStudentByphone(String phone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentByphone'");
    }

    // Remove the duplicated and unimplemented methods
    // @Override
    // public Student getStudentByphone(String phone) {
    //     throw new UnsupportedOperationException("Unimplemented method 'getStudentByphone'");
    // }

    // @Override
    // public String getName(String phone) {
    //     throw new UnsupportedOperationException("Unimplemented method 'getName'");
    // }
}
